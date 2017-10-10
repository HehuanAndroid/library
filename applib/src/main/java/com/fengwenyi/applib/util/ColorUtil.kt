package com.fengwenyi.applib.util

import android.graphics.Color
import android.os.Build


/**
 * Wenyi Feng(xfsy2014@gmail.com)
 * 2017-09-29 13:28
 */
object ColorUtil {

    /**
     * 随机颜色
     * @return: Int
     */
    fun random() : Int {
        return if (Build.VERSION.SDK_INT >= 26)
            Color.argb(MathUtil.randomNum(1, 0).toFloat(),
                    MathUtil.randomNum(255, 0).toFloat(),
                    MathUtil.randomNum(255, 0).toFloat(),
                    MathUtil.randomNum(255, 0).toFloat())
        else
            Color.rgb(MathUtil.randomNum(255, 0),
                    MathUtil.randomNum(255, 0),
                    MathUtil.randomNum(255, 0))
    }

    /**
     * 推荐颜色随机
     * @return: Int
     */
    fun randomRecommend() : Int = Constant.colors[MathUtil.randomNum(Constant.colors.size - 1, 0)]

    /**
     * 自定义颜色随机
     * @return: Int
     */
    fun randomCustom(colors : IntArray) : Int = colors[MathUtil.randomNum(colors.size - 1, 0)]

}