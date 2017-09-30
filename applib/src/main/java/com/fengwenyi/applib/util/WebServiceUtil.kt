package com.fengwenyi.applib.util

import android.os.Handler
import android.os.Message
import android.support.v4.util.SimpleArrayMap
import com.fengwenyi.applib.jk.ICallBack
import org.ksoap2.SoapEnvelope
import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.transport.HttpTransportSE
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException


/**
 * Wenyi Feng(xfsy2014@gmail.com)
 * 2017-09-29 15:58
 */
object WebServiceUtil {

    /**
     * 访问的服务器是否由dotNet开发
     */
    private var isDotNet : Boolean = false

    /**
     * 线程池的大小
     */
    private var threadSize : Int = 5

    /**
     * 创建一个可重用固定线程数的线程池，
     * 以共享的无界队列方式来运行这些线程
     */
    private var threadPool : ExecutorService = Executors.newFixedThreadPool(threadSize)

    private val SUCCESS_FLAG = 0
    private val ERROR_FLAG = 1

    fun call(endPoint : String,
             namespace : String,
             method : String,
             params : SimpleArrayMap<String, String>,
             callback : ICallBack<SoapObject>) {
        // 1.创建HttpTransportSE对象，传递WebService服务器地址
        val transport = HttpTransportSE(endPoint)
        transport.debug = true
        // 2.创建SoapObject对象用于传递请求参数
        val request = SoapObject(namespace, method)
        if (params != null) {
            for (i in 0 until params.size()) {
                val key = params.keyAt(i)
                val value = params.get(key)
                request.addProperty(key, value)
            }
        }
        // 3.实例化SoapSerializationEnvelope，传入WebService的SOAP协议的版本号
        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER12)
        envelope.dotNet = isDotNet
        envelope.setOutputSoapObject(request)

        // 4.用于子线程与主线程通信的Handler，网络请求成功时会在子线程发送一个消息，然后在主线程上接收
        val responseHandler = object : Handler() {

            override fun handleMessage(msg: Message) {
                // 根据消息的arg1值判断调用哪个接口
                if (msg.arg1 === SUCCESS_FLAG)
                    callback.onSuccess(msg.obj as SoapObject)
                else
                    callback.onFail(msg.obj.toString())
            }

        }

        // 5.提交一个子线程到线程池并在此线种内调用WebService
        if (threadPool == null || threadPool.isShutdown)
            threadPool = Executors.newFixedThreadPool(threadSize)

        threadPool.submit {
            var result: SoapObject? = null
            try {
                // 解决EOFException
                System.setProperty("http.keepAlive", "false")
                // 连接服务器
                transport.call(null, envelope)
                if (envelope.response != null) {
                    // 获取服务器响应返回的SoapObject
                    result = envelope.bodyIn as SoapObject
                }
            } catch (e: IOException) {
                // 当call方法的第一个参数为null时会有一定的概念抛IO异常
                // 因此需要需要捕捉此异常后用命名空间加方法名作为参数重新连接
                try {
                    transport.call(namespace + method, envelope)
                    if (envelope.response != null) {
                        // 获取服务器响应返回的SoapObject
                        result = envelope.bodyIn as SoapObject
                    }
                } catch (e1: Exception) {
                    responseHandler.sendMessage(responseHandler.obtainMessage(0, ERROR_FLAG, 0, e1))
                }

            } catch (e: XmlPullParserException) {
                responseHandler.sendMessage(responseHandler.obtainMessage(0, ERROR_FLAG, 0, e))
            } finally {
                // 将获取的消息利用Handler发送到主线程
                responseHandler.sendMessage(responseHandler.obtainMessage(0, SUCCESS_FLAG, 0, result))
            }
        }
    }

    /**
     * 设置线程池的大小
     * @param threadSize
     */
    fun setThreadSize(threadSize : Int) {
        this.threadSize = threadSize
        threadPool.shutdownNow()
        threadPool = Executors.newFixedThreadPool(this.threadSize);
    }

    /**
     * 设置是否由doNet开发
     * @param isDotNet
     */
    fun setIsDotNet(isDotNet : Boolean) {
        this.isDotNet = isDotNet
    }

}