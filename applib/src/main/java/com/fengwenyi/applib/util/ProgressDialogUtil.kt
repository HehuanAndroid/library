package com.fengwenyi.applib.util

import android.app.ProgressDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.fengwenyi.applib.R
import android.view.Gravity

/**
 * Wenyi Feng(xfsy2014@gmail.com)
 * 2017-09-30 15:40
 */
object ProgressDialogUtil {

    /**
     * 太极
     */
    val THEME_ULTIMATE = 0
    /**
     * 点（大）
     */
    val THEME_DOT = 1
    /**
     * 圆
     */
    val THEME_LINE = 2
    /**
     * 点（细）
     */
    val THEME_ARC = 3

    private lateinit var dialog : ProgressDialog
    private val param = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT)

    /**
     * 模糊对话框
     * @param context  上下文
     * @param msg  提示信息
     * @param theme    样式
     * @param isCanceledOnTouchOutside  点击外边距是否可取消
     * @param isCancelable 点击back键是否可取消
     */
    fun show(context : Context,
             msg : String,
             theme : Int,
             isCanceledOnTouchOutside : Boolean,
             isCancelable : Boolean) {
        dialog = ProgressDialog(context, R.style.indistinctProgressDialog)
        // 点击外边距是否可取消
        dialog.setCanceledOnTouchOutside(isCanceledOnTouchOutside)
        // 点击back键是否可取消
        dialog.setCancelable(isCancelable)
        val view = LayoutInflater.from(context)
                .inflate(R.layout.layout_indistinct_progress_dialog, null)
        val icon = view.findViewById<ImageView>(R.id.imgIPDIcon)
        // 设置样式
        icon.setImageResource(Constant.iconStyles[theme])
        val animation = AnimationUtils.loadAnimation(context, R.anim.ipd_img_rotate)
        icon.startAnimation(animation)
        val tip = view.findViewById<TextView>(R.id.tvIPDMsg)
        tip.text = msg
        // 显示
        dialog.show()
        dialog.setContentView(view, param)
    }

    /**
     * 模糊对话框
     * @param context  上下文
     * 默认样式，图标随机
     */
    fun show(context : Context) {
        dialog = ProgressDialog(context, R.style.indistinctProgressDialog)
        val view = LayoutInflater.from(context)
                .inflate(R.layout.layout_indistinct_progress_dialog, null)
        val icon = view.findViewById<ImageView>(R.id.imgIPDIcon)
        // 设置样式（随机）
        icon.setImageResource(Constant.iconStyles[MathUtil.randomNum(Constant.iconStyles.size - 1, 0)])
        val animation = AnimationUtils.loadAnimation(context, R.anim.ipd_img_rotate)
        icon.startAnimation(animation)
        // 显示
        dialog.show()
        dialog.setContentView(view, param)
    }

    /**
     * 仿IOS样式模糊进度对话框
     * @author: meihuali
     */
    fun showIos(context: Context,
                message: CharSequence,
                isCanceledOnTouchOutside: Boolean,
                isCancelable : Boolean) {
        dialog = ProgressDialog(context, R.style.progressDialogIos)
        // 点击外边距是否可取消
        dialog.setCanceledOnTouchOutside(isCanceledOnTouchOutside)
        // 点击back键是否可取消
        dialog.setCancelable(isCancelable)
        dialog.setContentView(R.layout.layout_progress_dialog_ios)
        val tvMsg = dialog.findViewById<TextView>(R.id.message)
        if (message == null || message.length === 0) {
            tvMsg.visibility = View.GONE
        } else {
            tvMsg.text = message
        }
        // 设置居中
        dialog.window.attributes.gravity = Gravity.CENTER
        val lp = dialog.window.attributes
        // 设置背景层透明度
        lp.dimAmount = 0.2f
        dialog.window.attributes = lp
        dialog.show()
    }

    /**
     * 对话框的当前状态
     */
    fun isShowing() : Boolean = dialog != null && dialog.isShowing

    /**
     * 取消对话框
     */
    fun dismiss() {
        if (isShowing()) dialog.dismiss()
    }
}