package com.fengwenyi.app.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Name   : Utils
 * Desc   : ...
 * Use    : ...
 * Author : xfsyMrFeng
 * Tool   : Android studio
 * Date   : 2017-07-07
 * Time   : 15:07
 */

public class UtilWenyiFeng {

    /**
     * 弹窗
     * @param context
     * @param msg
     */
    public static void toast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 检查当前网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
        } else {
            /*NetworkInfo[] info = cm.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }*/
            // 仅仅判断网络是否可用
            return cm.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }
}
