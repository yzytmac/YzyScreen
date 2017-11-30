package com.example.yzyscreenadaptive;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.HashMap;

/**
 * Created by yzy on 17-11-30.
 */

public class PercentRelativeLayout extends RelativeLayout {
    private float percentWidth = 0;
    private float percentHeight = 0;
    private HashMap<Integer, Integer> lastWidths = new HashMap<>();//判断是否为宽度赋值
    private HashMap<Integer, Integer> lastHeights = new HashMap<>();//判断是否为高度赋值

    public PercentRelativeLayout(Context context) {
        super(context);
    }

    /**
     * 这里的属性是控件自身的属性
     *
     * @param context
     * @param attrs
     */
    public PercentRelativeLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 这里的属性是控件内部的child的属性，所以要获取里面child所占的百分比就要使用这里面的attrs
     *
     * @param attrs
     * @return 返回一个布局参数，该布局参数我们也可以自定义，继承相应的LayoutParams即可
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        TypedArray vTypedArray = getContext().obtainStyledAttributes(attrs, R.styleable.PercentLinearLayout);
        percentWidth = vTypedArray.getFloat(R.styleable.PercentLinearLayout_layout_percent_width, percentWidth);
        percentHeight = vTypedArray.getFloat(R.styleable.PercentLinearLayout_layout_percent_height, percentHeight);
        return super.generateLayoutParams(attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int vChildCount = getChildCount();
        for (int i = 0; i < vChildCount; i++) {
            View vChild = getChildAt(i);
            ViewGroup.LayoutParams vLayoutParams = vChild.getLayoutParams();
            /*之所以加上这一系列判断是为了兼容外部怼宽高值的处理，如果外部一开始就设置了具体的宽高值，那么百分比就不执行
            * 如果外部没有给具体的宽高，那么就需要百分比代码执行，而hasw、hasH这个判断是因为onMeasure方法会多次调用，
            * vLayoutParams.width就会有值，再次onMeasure时就不再走百分比代码了
            * */

            //解决onMeasure二次执行后不走百分比代码导致绘图不准
            if (percentWidth > 0 && lastWidths.get(i) != null) {//对宽度赋过值，才执行
                vLayoutParams.width = (int) (percentWidth * width);
            }

            if (percentHeight > 0 && lastHeights.get(i) != null) {
                vLayoutParams.height = (int) (percentHeight * height);
            }

            //当外部有值时就不走百分比
            if (vLayoutParams.width == ViewGroup.LayoutParams.MATCH_PARENT ||
                    vLayoutParams.width == ViewGroup.LayoutParams.WRAP_CONTENT) {
                if (percentWidth > 0) {
                    vLayoutParams.width = (int) (percentWidth * width);
                }
                lastWidths.put(i, vLayoutParams.width);
            }

            if (vLayoutParams.height == ViewGroup.LayoutParams.MATCH_PARENT ||
                    vLayoutParams.height == ViewGroup.LayoutParams.WRAP_CONTENT) {
                if (percentHeight > 0) {
                    vLayoutParams.height = (int) (percentHeight * height);
                }
                lastHeights.put(i, vLayoutParams.height);
            }
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


}
