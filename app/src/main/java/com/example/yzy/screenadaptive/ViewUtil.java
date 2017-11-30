package com.example.yzy.screenadaptive;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by yzy on 2017/11/29.
 */

public class ViewUtil {
    private Context mContext;
    private static ViewUtil instance;
    private ViewUtil(Context pContext){
        mContext = pContext;
    }
    public static ViewUtil getInstance(Context pContext){
        if(instance==null) {
            instance = new ViewUtil(pContext);
        }
        return instance;
    }

    public void setLayoutParams(View view, int width, int height, int left, int top, int right, int bottom){
        ViewGroup.MarginLayoutParams vLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if(width!= ViewGroup.LayoutParams.MATCH_PARENT && width!=ViewGroup.LayoutParams.WRAP_CONTENT) {
            vLayoutParams.width = UiUtil.getInstance(mContext).getWidth(width);
        }else {
            vLayoutParams.width = width;
        }

        if(height!=ViewGroup.LayoutParams.MATCH_PARENT && height!=ViewGroup.LayoutParams.WRAP_CONTENT) {
            vLayoutParams.height = UiUtil.getInstance(mContext).getHeight(height);
        }else {
            vLayoutParams.height = height;
        }

        //横向上的用getWidth,竖着的用getHeight
        vLayoutParams.leftMargin = UiUtil.getInstance(mContext).getWidth(left);
        vLayoutParams.rightMargin = UiUtil.getInstance(mContext).getWidth(right);
        vLayoutParams.topMargin = UiUtil.getInstance(mContext).getHeight(top);
        vLayoutParams.bottomMargin = UiUtil.getInstance(mContext).getHeight(bottom);

        view.setLayoutParams(vLayoutParams);

    }

}
