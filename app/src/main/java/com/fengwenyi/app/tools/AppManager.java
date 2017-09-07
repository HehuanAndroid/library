package com.fengwenyi.app.tools;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * WenyiFeng(xfsy2014@gmail.com)
 * 2017-07-18 15:22
 */

public class AppManager {

    private static Stack<Activity> activityStack;
    private static AppManager instance;

    public AppManager() {
    }

    /**
     * 单一实例
     * @return AppManager
     */
    public static AppManager getInstance() {
        if (null == instance) {
            instance = new AppManager();
        }
        return instance;
    }

    /**
     * 将 Activity 添加到堆栈中
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (null == activityStack) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前 Activity
     * @return
     */
    public Activity getCurrentActivity() {
        return activityStack.lastElement();
    }

    /**
     * 关闭当前 Activity
     */
    public void finishCurrentActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 关闭指定的 Activity
     * @param activity
     */
    public void finishActivity(Activity activity) {
        if (null != activity) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 关闭所有 Activity
     */
    public void finishAllActivity() {
        for (int i = 0; i < activityStack.size(); i++) {
            Activity activity = activityStack.get(i);
            if (null != activity) {
                activity.finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出APP
     * @param context 上下文
     */
    @Deprecated
    public void AppExit(Context context) {
        finishAllActivity();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.killBackgroundProcesses(context.getPackageName());
        System.exit(0);
    }

    /**
     * 退出APP
     * @param context 上下文
     */
    public void appExit(Context context) {
        finishAllActivity();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.killBackgroundProcesses(context.getPackageName());
        System.exit(0);
    }
}
