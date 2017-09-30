package com.fengwenyi.applib.util

import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Wenyi Feng(xfsy2014@gmail.com)
 * 2017-09-29 14:49
 */
object FontImgUtil {

    fun injectFont(rootView : View) = injectFont(rootView,
            Typeface.createFromAsset(rootView.context.assets, Constant.DEF_FONT))

    fun injectFont(rootView: View, tf : Typeface) {
        if (rootView is ViewGroup) {
            val count = rootView.childCount
            for (i in 0 until count) injectFont(rootView.getChildAt(i), tf)
        } else if (rootView is TextView) rootView.typeface = tf
    }
}