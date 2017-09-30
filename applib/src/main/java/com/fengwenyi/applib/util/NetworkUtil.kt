package com.fengwenyi.applib.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Wenyi Feng(xfsy2014@gmail.com)
 * 2017-09-30 15:00
 */
object NetworkUtil {

    /**
     * 检查当前网络是否可用
     * @param context 上下文
     * @return true(可用); false(不可用)
     */
    fun isAvailable(context: Context): Boolean {
        val cm = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (cm != null){
            val info = cm.allNetworkInfo
            if (info != null) {
                info.indices
                        .filter { info[it].state == NetworkInfo.State.CONNECTED }
                        .forEach { return true }
            }
        }
        return false
    }
}