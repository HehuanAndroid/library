package com.fengwenyi.applib.util

import java.io.*


/**
 * Wenyi Feng(xfsy2014@gmail.com)
 * 2017-09-29 14:08
 */
object FileUtil {

    /**
     * 将字符串写入到文件中
     * @param path 文件位置
     * @param str 字符串
     * @param isNewMode 写入方式（true追加; false覆盖）
     */
    fun write(path : String, str : String, isNewMode : Boolean) {
        val file = File(path)
        if (!file.exists()) file.createNewFile()
        val out = FileOutputStream(file, isNewMode)
        val sb = StringBuffer()
        sb.append(str)
        out.write(sb.toString().toByteArray()) // 默认为UTF-8
        out.close()
    }
}