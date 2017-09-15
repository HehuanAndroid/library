package com.fengwenyi.app.tools

import android.content.Context
import android.widget.Toast

/**
 * WenyiFeng(xfsy2014@gmail.com)
 * 2017-09-15 10:52
 */
class ToastWenyiFeng {

    companion object {

        var isShow = true

        fun isShow(showIs : Boolean) {
            isShow = showIs
        }

        /**
         * 短时间显示，字符类型
         */
        fun showShort(context: Context, msg : CharSequence) {
            if (isShow)
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }

        /**
         * 短时间显示，Int
         */
        fun showShort(context: Context, msg : Int) {
            if (isShow)
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }

        /**
         * 长时间显示，字符类型
         */
        fun showLong(context: Context, msg : CharSequence) {
            if (isShow)
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }

        /**
         * 长时间显示，Int
         */
        fun showLong(context: Context, msg : Int) {
            if (isShow)
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }

        /**
         * 自定义时间显示，字符类型
         */
        fun show(context: Context, msg : CharSequence, duration : Int) {
            if (isShow)
                Toast.makeText(context, msg, duration).show()
        }

        /**
         * 自定义时间显示，Int
         */
        fun show(context: Context, msg : Int, duration : Int) {
            if (isShow)
                Toast.makeText(context, msg, duration).show()
        }
    }

}