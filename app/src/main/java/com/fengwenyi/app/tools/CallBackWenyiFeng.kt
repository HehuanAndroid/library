package com.fengwenyi.app.tools

/**
 * WenyiFeng(xfsy2014@gmail.com)
 * 2017-09-01 17:19
 */
interface CallBackWenyiFeng<in T> {

    fun onSuccess(t : T)

    fun onFail(msg : String?)

}