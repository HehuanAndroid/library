package com.fengwenyi.app.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * WenyiFeng(xfsy2014@gmail.com)
 * 2017-07-07 15:07
 */

public class UtilWenyiFeng {

    /**
     * 文字弹窗提示
     * @param context 上下文
     * @param msg 提示文字
     */
    @Deprecated
    public static void toast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 检查当前网络是否可用
     * @param context 上下文
     * @return true(可用); false(不可用)
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
        } else {
            NetworkInfo[] info = cm.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 跳转
     * @param context 上下文
     * @param cls     目标页面
     * @param isFinishCurrent  是否需要关闭当前页面
     */
    public static void intent(Context context, Class<?> cls, boolean isFinishCurrent) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
        if (isFinishCurrent)
            AppManager.getInstance().finishCurrentActivity();
    }
}
