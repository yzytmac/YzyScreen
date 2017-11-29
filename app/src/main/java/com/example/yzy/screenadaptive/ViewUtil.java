package com.example.yzy.screenadaptive;

import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by yzy on 2017/11/29.
 */

public class ViewUtil {
    public static void setLinearLayoutParams(View view,int width,int height,int left,int top,int right,int bottom){
        LinearLayout.LayoutParams vLayoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if(width!=LinearLayout.LayoutParams.MATCH_PARENT && width!=LinearLayout.LayoutParams.WRAP_CONTENT) {
            vLayoutParams.width = UiUtil.getInstance(YzyApplication.getInstance()).getWidth(width);
        }else {
            vLayoutParams.width = width;
        }

        if(height!=LinearLayout.LayoutParams.MATCH_PARENT && height!=LinearLayout.LayoutParams.WRAP_CONTENT) {
            vLayoutParams.height = UiUtil.getInstance(YzyApplication.getInstance()).getHeight(height);
        }else {
            vLayoutParams.height = height;
        }

        //横向上的用getWidth,竖着的用getHeight
        vLayoutParams.leftMargin = UiUtil.getInstance(YzyApplication.getInstance()).getWidth(left);
        vLayoutParams.rightMargin = UiUtil.getInstance(YzyApplication.getInstance()).getWidth(right);
        vLayoutParams.topMargin = UiUtil.getInstance(YzyApplication.getInstance()).getHeight(top);
        vLayoutParams.bottomMargin = UiUtil.getInstance(YzyApplication.getInstance()).getHeight(bottom);

        view.setLayoutParams(vLayoutParams);

    }
}
