package com.fengwenyi.applib.util

import java.util.*

/**
 * Wenyi Feng(xfsy2014@gmail.com)
 * 2017-09-29 13:34
 */
object MathUtil {

    /**
     * 随机数
     * @param range
     * @return [0, range)
     */
    fun randomNum(range : Int) : Double  = Math.random()*range

    /**
     * 随机数
     * @param x 最大值
     * @param y 最小值
     * @return [y, x]
     */
    fun randomNum(x : Int, y : Int) : Int {
        val max = x + 1
        val min = y + 1
        val random = Random()
        val result = random.nextInt(max)%(max-min+1) + min
        return result - 1
    }

}