package com.fengwenyi.app.tools;

import android.graphics.Color;
import android.os.Build;

/**
 * WenyiFeng(xfsy2014@gmail.com)
 * 2017-09-20 14:03
 */

public class ColorUtilWenyiFeng {

    /**
     * 随机颜色
     * @return
     */
    public static int random() {
        if (Build.VERSION.SDK_INT >= 26)
            return Color.argb((float) UtilWenyiFeng.randomNum(1, 0),
                    (int)UtilWenyiFeng.randomNum(255, 0),
                    (int)UtilWenyiFeng.randomNum(255, 0),
                    (int)UtilWenyiFeng.randomNum(255, 0));
        else
            return Color.rgb((int)UtilWenyiFeng.randomNum(255, 0),
                    (int)UtilWenyiFeng.randomNum(255, 0),
                    (int)UtilWenyiFeng.randomNum(255, 0));
    }
}
