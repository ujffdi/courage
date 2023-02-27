package com.tongsr.core.component;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

import androidx.annotation.ColorInt;

import com.blankj.utilcode.util.ColorUtils;
import com.tongsr.core.R;


/**
 * @author Tongsr
 * @version 1.0
 * @date 2020/8/31
 * @email ujffdtfivkg@gmail.com
 * @description 生成一个Drawable，代替编写shape文件
 */
public final class DrawableBuilder {

    /**
     * 默认线条粗细
     */
    private static final float defaultLineWidth = 0.5F;
    /**
     * 默认线条颜色
     */
    private static final int defaultLineColor = ColorUtils.getColor(R.color.line);
    /**
     * 默认圆角
     */
    private static final int defaultCornerRadius = 2;
    /**
     * 默认椭圆形圆角
     */
    private static final int defaultRoundCornerRadius = 100;
    /**
     * 默认虚线条单位长度
     */
    private static final int defaultDashWidth = 6;
    /**
     * 默认虚线条之间的间距
     */
    private static final int defaultDashGap = 2;
    /**
     * 线的宽度
     */
    private int lineWidth = 0;
    /**
     * 线的颜色
     */
    @ColorInt
    private int lineColor = Color.TRANSPARENT;
    /**
     * 默认圆角度数
     */
    private float cornerRadius = dp2px(2);
    /**
     * 每连续的两个数值表示是一个角度,四组:左上,右上,右下,左下
     */
    private float[] radius;
    /**
     * 渐变的形状模式
     */
    private int shape = GradientDrawable.RECTANGLE;
    /**
     * 渐变的方向
     */
    private final GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
    /**
     * 渐变的颜色数组
     */
    private int[] gradualColors;
    /**
     * 背景颜色，默认透明
     */
    @ColorInt
    private int bkColor = Color.TRANSPARENT;
    /**
     * 虚线边框每个单元的长度
     */
    private float dashWidth = 0;
    /**
     * 虚线边框每个单元之间的间距
     */
    private float dashGap = 0;

    public Drawable build() {
        final GradientDrawable bg = new GradientDrawable();
        bg.setShape(shape);
        bg.setStroke(lineWidth, lineColor, dashWidth, dashGap);
        bg.setColor(bkColor);
        if (radius != null && radius.length > 0) {
            bg.setCornerRadii(radius);
        } else {
            bg.setCornerRadius(cornerRadius);
        }
        if (gradualColors != null && gradualColors.length > 0) {
            bg.setOrientation(orientation);
            bg.setColors(gradualColors);
        }
        return bg;
    }

    /**
     * 设置渐变的形状类型
     *
     * @param shape shape
     * @return this
     */
    public DrawableBuilder shape(int shape) {
        this.shape = shape;
        return this;
    }

    /**
     * 设置渐变开始到结束的颜色值
     *
     * @param startColor startColor
     * @param endColor   endColor
     * @return this
     */
    public DrawableBuilder gradualLinear(@ColorInt int startColor, @ColorInt int endColor) {
        this.gradualColors = new int[]{startColor, endColor};
        return this;
    }

    /**
     * 构造线框
     *
     * @return this
     */
    public DrawableBuilder line() {
        return line(defaultLineWidth, defaultLineColor);
    }

    /**
     * 构造线框
     *
     * @param color color
     * @return this
     */
    public DrawableBuilder line(@ColorInt int color) {
        return line(defaultLineWidth, color);
    }

    /**
     * 构造线框
     *
     * @param width width
     * @param color color
     * @return this
     */
    public DrawableBuilder line(float width, int color) {
        return lineWidth(width).lineColor(color);
    }

    /**
     * 构造线框
     *
     * @param width width
     * @param color color
     * @return this
     */
    public DrawableBuilder line(float width, String color) {
        return lineWidth(width).lineColor(color);
    }

    /**
     * 设置边框线条粗细 直接传入具体数值
     *
     * @return this
     */
    public DrawableBuilder lineWidth(float lineWidth) {
        this.lineWidth = dp2px(lineWidth);
        return this;
    }

    /**
     * 线框的颜色
     *
     * @param lineColor lineColor
     * @return this
     */
    public DrawableBuilder lineColor(@ColorInt int lineColor) {
        this.lineColor = lineColor;
        return this;
    }

    /**
     * 线框的颜色
     *
     * @param lineColor lineColor
     * @return this
     */
    public DrawableBuilder lineColor(String lineColor) {
        if (lineColor.charAt(0) != '#') {
            throw new IllegalArgumentException("color value must be start with # like #000000");
        }
        return lineColor(Color.parseColor(lineColor));
    }

    /**
     * 设置圆角度数，直接传入具体数值
     *
     * @param cornerRadius cornerRadius
     * @return this
     */
    public DrawableBuilder corner(float cornerRadius) {
        this.cornerRadius = dp2px(cornerRadius);
        return this;
    }

    public DrawableBuilder corner(int cornerRadius) {
        this.cornerRadius = dp2px(cornerRadius);
        return this;
    }

    /**
     * 设置每个位置的圆角
     *
     * @param topLeftRadius     topLeftRadius
     * @param topRightRadius    topRightRadius
     * @param bottomRightRadius bottomRightRadius
     * @param bottomLeftRadius  bottomLeftRadius
     * @return this
     */
    public DrawableBuilder corner(int topLeftRadius
            , int topRightRadius, int bottomRightRadius, int bottomLeftRadius) {
        this.radius = new float[]{dp2px(topLeftRadius), dp2px(topLeftRadius)
                , dp2px(topRightRadius), dp2px(topRightRadius)
                , dp2px(bottomRightRadius), dp2px(bottomRightRadius)
                , dp2px(bottomLeftRadius), dp2px(bottomLeftRadius)};
        return this;
    }

    /**
     * 配置默认的圆角度数 为2
     *
     * @return this
     */
    public DrawableBuilder corner() {
        return corner(defaultCornerRadius);
    }

    /**
     * 大圆角
     *
     * @return this
     */
    public DrawableBuilder roundCorner() {
        return corner(defaultRoundCornerRadius);
    }

    /**
     * 填充颜色
     *
     * @param bkColor bkColor
     * @return this
     */
    public DrawableBuilder fill(@ColorInt int bkColor) {
        this.bkColor = bkColor;
        return this;
    }

    /**
     * 填充颜色
     *
     * @param bkColor bkColor
     * @return this
     */
    public DrawableBuilder fill(String bkColor) {
        if (bkColor.charAt(0) != '#') {
            throw new IllegalArgumentException("color value must be start with # like #000000");
        }
        return fill(Color.parseColor(bkColor));
    }

    /**
     * 生成一个默认的虚线 shape
     *
     * @return DrawableBuilder
     */
    public DrawableBuilder dash() {
        return dashWidth(defaultDashWidth).dashGap(defaultDashGap);
    }

    /**
     * 虚线边框每个单元的长度
     *
     * @param dashWidth dashWidth
     * @return this
     */
    public DrawableBuilder dashWidth(float dashWidth) {
        this.dashWidth = dp2px(dashWidth);
        return this;
    }

    /**
     * 虚线边框每个单元之间的间距
     *
     * @param dashGap dashGap
     * @return this
     */
    public DrawableBuilder dashGap(float dashGap) {
        this.dashGap = dp2px(dashGap);
        return this;
    }

    /**
     * Value of dp to value of px.
     *
     * @param dpValue The value of dp.
     * @return value of px
     */
    public int dp2px(final float dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
