package com.fengwenyi.app.tools;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * WenyiFeng(xfsy2014@gmail.com)
 * 2017/5/23 0023.
 */

public class FontImgWenyiFeng {

    public static final String FONTS_DIR = "fonts/";
    public static final String DEF_FONT = FONTS_DIR + "fontawesome-webfont.ttf";

    public static final void injectFont(View rootView) {
        injectFont(rootView, Typeface.createFromAsset(rootView.getContext()
                .getAssets(), DEF_FONT));
    }

    public static final void injectFont(View rootView, Typeface tf) {
        if(rootView instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) rootView;
            int count = group.getChildCount();
            for(int i=0;i<count;i++) {
                injectFont(group.getChildAt(i), tf);
            }
        }else if(rootView instanceof TextView) {
            ((TextView) rootView).setTypeface(tf);
        }
    }
}
