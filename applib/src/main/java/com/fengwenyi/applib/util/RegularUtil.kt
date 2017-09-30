package com.fengwenyi.applib.util

import java.util.regex.Pattern

/**
 * Wenyi Feng(xfsy2014@gmail.com)
 * 2017-09-29 15:14
 */
object RegularUtil {

    /**
     * 正则验证
     * @param REGEX 正则表达式
     * @param str 待验证的字符串
     * @return Boolean 待验证字符串是否满足正则表达式，true是，false否
     */
    fun verify(REGEX : String, str : String) : Boolean = Pattern.matches(REGEX, str)

}