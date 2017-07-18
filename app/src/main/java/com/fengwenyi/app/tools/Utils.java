package com.fengwenyi.app.tools;

import android.content.Context;
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

public class Utils {

    /**
     * 弹窗
     * @param context
     * @param msg
     */
    public static void toast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
