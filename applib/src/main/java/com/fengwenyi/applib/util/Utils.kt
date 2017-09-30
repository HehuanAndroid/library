package com.fengwenyi.applib.util

import android.content.Context
import android.content.Intent

/**
 * Wenyi Feng(xfsy2014@gmail.com)
 * 2017-09-30 15:08
 */
object Utils {

    /**
     * 跳转
     * @param context 上下文
     * @param cls     目标页面
     */
    fun intent(context: Context, cls: Class<*>) {
        val intent = Intent(context, cls)
        context.startActivity(intent)
    }
}