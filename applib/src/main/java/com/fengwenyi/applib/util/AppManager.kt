package com.fengwenyi.applib.util

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * Wenyi Feng(xfsy2014@gmail.com)
 * 2017-09-29 11:03
 */
class AppManager {

    private lateinit var activityStack: Stack<Activity>

    /**
     * 将 Activity 添加到堆栈中
     * @param activity
     */
    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }

    /**
     * 关闭指定的 Activity
     * @param activity
     */
    fun finishActivity(activity: Activity) {
        activityStack.remove(activity)
        activity.finish()
    }

    /**
     * 关闭所有 Activity
     */
    fun finishAllActivity() {
        for (activity in activityStack) activity.finish()
        activityStack.clear()
    }

    /**
     * 退出APP
     * @param context 上下文
     */
    fun appExit(context : Context) {
        finishAllActivity()
        val manager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        manager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }

    companion object {

        /**
         * 通过静态实例化来实现单例模式
         */
        val instance = AppManager()

    }
}