package com.fengwenyi.applib.util

import android.content.Context
import android.widget.Toast

/**
 * Wenyi Feng(xfsy2014@gmail.com)
 * 2017-09-27 16:29
 */
object ToastUtil {

    /**
     * 默认toast
     * @param context 上下文
     * @param msg
     */
    fun show(context: Context, msg : CharSequence)
            = Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

    /**
     * 默认toast
     * @param context 上下文
     * @param msg
     */
    fun show(context: Context, msg : Int)
            = Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}