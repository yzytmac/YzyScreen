package com.example.yzyscreenadaptive;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * Created by yzy on 2017/11/29.
 * 根据美工的基准生成我们需要的值
 */

public class UiUtil {
    private static UiUtil instance;
    private static int BASE_WIDTH;//美工的基准
    private static int BASE_HEIGHT;//美工的基准1920-72，因为后面显示的部分减去了72
    private static final String DIMEN_CLASS = "com.android.internal.R$dimen";
    private static final String STATUS_BAR_HEIGHT = "status_bar_height";
    private float displayWidth;
    private float displayHeight;

    public static UiUtil getInstance(Context pContext){
        return getInstance(pContext,1080,1920);
    }

    public static UiUtil getInstance(Context pContext,int baseWidth,int baseHeight){
        if(instance==null) {
            instance = new UiUtil(pContext,baseWidth,baseHeight);
        }
        return instance;
    }


    private UiUtil(Context pContext,int baseWidth,int baseHeight) {
        int systemBarHeight = getSystemBarHeight(pContext);//获取状态栏的高度
        Log.e("yzy", "UiUtil: " + systemBarHeight);
        BASE_WIDTH = baseWidth;
        BASE_HEIGHT = baseHeight-systemBarHeight;
        //获取屏幕真是宽高
        WindowManager vWindowManager = (WindowManager) pContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics vMetrics = new DisplayMetrics();
        if (displayWidth == 0.0f || displayHeight == 0.0f) {
            vWindowManager.getDefaultDisplay().getMetrics(vMetrics);//获取系统的屏幕值存到vMetrics 中

            if(vMetrics.heightPixels>vMetrics.widthPixels) {//代表竖屏
                displayWidth = vMetrics.widthPixels;
                displayHeight = vMetrics.heightPixels-systemBarHeight;//要去掉状态栏的高度，如果是虚拟按键还要减去虚拟按键的高度，暂时不考虑
            }else {//代表横屏
                displayWidth = vMetrics.heightPixels;
                displayHeight = vMetrics.widthPixels-systemBarHeight;//要去掉状态栏的高度，如果是虚拟按键还要减去虚拟按键的高度，暂时不考虑
            }
        }
    }

    /**
     * 获取系统状态栏的高度
     *
     * @param pContext
     * @return
     */
    private int getSystemBarHeight(Context pContext) {
        try {
            Class<?> clazz = Class.forName(DIMEN_CLASS);
            Object obj = clazz.newInstance();
            Field vField = clazz.getField(STATUS_BAR_HEIGHT);
            String value = vField.get(obj).toString();
            int resID = Integer.parseInt(value);
            return pContext.getResources().getDimensionPixelOffset(resID);//根据id得到像素值
        } catch (Exception pE) {
            Log.e("yzy", "getSystemBarHeight: " + pE);
            return 72;//万一没有获取到就返回默认的72像素
        }
    }

    /**
     * 传入ui的宽度像素，返回缩放后的宽度
     * @param uiWidth
     * @return
     */
    public int getWidth(float uiWidth){
        return (int) (uiWidth*displayWidth/BASE_WIDTH);
    }

    /**
     * 传入ui的高度像素，返回缩放后的高度
     * @param uiHeight
     * @return
     */
    public int getHeight(float uiHeight){
        return (int) (uiHeight*displayHeight/BASE_HEIGHT);
    }


}
