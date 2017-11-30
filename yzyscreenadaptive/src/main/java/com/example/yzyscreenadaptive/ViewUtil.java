package com.example.yzyscreenadaptive;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yzy on 2017/11/29.
 */

public class ViewUtil {
    private Context mContext;
    private static ViewUtil instance;
    private UiUtil mUiUtil;

    private ViewUtil(Context pContext,int baseWidth,int baseHeight){
        mContext = pContext;
        mUiUtil = UiUtil.getInstance(mContext,baseWidth,baseHeight);
    }
    public static ViewUtil getInstance(Context pContext,int baseWidth,int baseHeight){
        if(instance==null) {
            instance = new ViewUtil(pContext,baseWidth,baseHeight);
        }
        return instance;
    }

    public void setLayoutParams(View view, int width, int height, int left, int top, int right, int bottom){
        ViewGroup.MarginLayoutParams vLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if(width!= ViewGroup.LayoutParams.MATCH_PARENT && width!=ViewGroup.LayoutParams.WRAP_CONTENT) {
            vLayoutParams.width = mUiUtil.getWidth(width);
        }else {
            vLayoutParams.width = width;
        }

        if(height!=ViewGroup.LayoutParams.MATCH_PARENT && height!=ViewGroup.LayoutParams.WRAP_CONTENT) {
            vLayoutParams.height = mUiUtil.getHeight(height);
        }else {
            vLayoutParams.height = height;
        }

        //横向上的用getWidth,竖着的用getHeight
        vLayoutParams.leftMargin = mUiUtil.getWidth(left);
        vLayoutParams.rightMargin = mUiUtil.getWidth(right);
        vLayoutParams.topMargin = mUiUtil.getHeight(top);
        vLayoutParams.bottomMargin = mUiUtil.getHeight(bottom);

        view.setLayoutParams(vLayoutParams);

    }

}
