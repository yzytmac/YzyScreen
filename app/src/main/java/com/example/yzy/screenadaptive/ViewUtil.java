package com.example.yzy.screenadaptive;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

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

    public void setLinearLayoutParams(View view,int width,int height,int left,int top,int right,int bottom){
        LinearLayout.LayoutParams vLayoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if(width!=LinearLayout.LayoutParams.MATCH_PARENT && width!=LinearLayout.LayoutParams.WRAP_CONTENT) {
            vLayoutParams.width = UiUtil.getInstance(mContext).getWidth(width);
        }else {
            vLayoutParams.width = width;
        }

        if(height!=LinearLayout.LayoutParams.MATCH_PARENT && height!=LinearLayout.LayoutParams.WRAP_CONTENT) {
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
