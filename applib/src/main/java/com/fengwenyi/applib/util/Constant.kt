package com.fengwenyi.applib.util

import android.graphics.Color
import com.fengwenyi.applib.R

/**
 * Wenyi Feng(xfsy2014@gmail.com)
 * 2017-09-29 13:54
 */
object Constant {

    /**
     * 标记
     */
    val TAG = "FWY_TAG"

    /**
     * 颜色数组
     */
    val colors = arrayOf(
            Color.parseColor("#000000"), Color.parseColor("#7F7F7F"),
            Color.parseColor("#880015"), Color.parseColor("#ED1C24"),
            Color.parseColor("#FF7F27"), Color.parseColor("#FFF200"),
            Color.parseColor("#22B14C"), Color.parseColor("#00A2E8"),
            Color.parseColor("#3F48CC"), Color.parseColor("#A349A4"),
            Color.parseColor("#B97A57"), Color.parseColor("#FFAEC9"),
            Color.parseColor("#B5E61D"), Color.parseColor("#99D9EA"),
            Color.parseColor("#7092BE"), Color.parseColor("#C8BFE7"))

    /**
     * 字体文件夹
     */
    val FONTS_DIR = "fonts/"

    /**
     * 字体
     */
    val DEF_FONT = FONTS_DIR + "fontawesome-webfont.ttf"

    /**
     * 正则：用户名
     */
    val REGEX_USERNAME = "^[a-zA-Z]\\w{5,20}$"

    /**
     * 正则：密码
     */
    val REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$"

    /**
     * 正则：手机号
     */
    val REGEX_PHONE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$"

    /**
     * 正则：email
     */
    val REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"

    /**
     * 正则：中文
     */
    val REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$"

    /**
     * 正则：身份证号码
     */
    val REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)"

    /**
     * 正则：uri
     */
    val REGEX_URI = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?"

    /**
     * 正则：ip
     */
    val REGEX_IP = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)"

    /**
     * 正则：数字
     */
    val REGEX_NUMBER = "^[0-9]$"

    /**
     * 模糊对话框的图标样式集合
     */
    val iconStyles = arrayOf(R.drawable.icon_progress_style1,
            R.drawable.icon_progress_style2,
            R.drawable.icon_progress_style3,
            R.drawable.icon_progress_style4)


}