package com.fengwenyi.applib.jk

/**
 * Wenyi Feng(xfsy2014@gmail.com)
 * 2017-09-27 16:18
 */
interface ICallBack<in T> {

    /**
     * 成功
     */
    fun onSuccess(t : T?)

    /**
     * 失败
     */
    fun onFail(msg : String?)

}