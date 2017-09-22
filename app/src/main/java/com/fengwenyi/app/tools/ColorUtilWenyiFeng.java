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

    /**
     * 推荐颜色随机
     * @return
     */
    public static int randomRecommend() {
        int [] colors = {Color.parseColor("#000000"), Color.parseColor("#7F7F7F"), Color.parseColor("#880015"),
                Color.parseColor("#ED1C24"), Color.parseColor("#FF7F27"), Color.parseColor("#FFF200"),
                Color.parseColor("#22B14C"), Color.parseColor("#00A2E8"), Color.parseColor("#3F48CC"),
                Color.parseColor("#A349A4"), Color.parseColor("#B97A57"), Color.parseColor("#FFAEC9"),
                Color.parseColor("#B5E61D"), Color.parseColor("#99D9EA"), Color.parseColor("#7092BE"),
                Color.parseColor("#C8BFE7")};
        int randomNum = (int) UtilWenyiFeng.randomNum(15, 0);
        return colors[randomNum];
    }

    /**
     * 自定义颜色随机
     * @param customColors
     * @return
     */
    public static int randomCustom(int ... customColors) {
        int [] colors = customColors;
        int colorCount = customColors.length;
        int randomNum = (int) UtilWenyiFeng.randomNum(colorCount - 1, 0);
        return colors[randomNum];
    }
}
