package com.tongsr.core.extend

import android.view.View
import androidx.annotation.ColorInt
import com.tongsr.core.component.DrawableBuilder

/**
 * @author Tongsr
 * @version 1.0
 * @date 2021/10/20
 * @email ujffdtfivkg@gmail.com
 * @description DrawableBuilder扩展
 */

/**
 * 设置圆角
 * @param radius 圆角半径
 */
fun View.corner(radius: Int) {
    this.background = DrawableBuilder()
        .corner(radius)
        .build()
}

/**
 * 设置顶部圆角
 * @param radius 圆角半径
 */
fun View.topCorner(radius: Int,@ColorInt color: Int) {
    this.background = DrawableBuilder()
        .corner(radius, radius, 0, 0)
        .fill(color)
        .build()
}


/**
 * 设置底部圆角
 * @param radius 圆角半径
 */
fun View.bottomCorner(radius: Int) {
    this.background = DrawableBuilder()
        .corner(0, 0, radius, radius)
        .build()
}

/**
 * 设置左侧圆角
 * @param radius 圆角半径
 */
fun View.leftCorner(radius: Int) {
    this.background = DrawableBuilder()
        .corner(radius, 0, 0, radius)
        .build()
}

/**
 * 设置右侧圆角
 * @param radius 圆角半径
 */
fun View.rightCorner(radius: Int) {
    this.background = DrawableBuilder()
        .corner(0, radius, radius, 0)
        .build()
}

/**
 * 设置背景
 * @param bgColor   背景颜色
 * @param radius    圆角半径
 * @param lineWidth 线框宽度
 * @param lineColor 线框颜色
 */
fun View.drawableBuilder(
    @ColorInt bgColor: Int,
    radius: Int,
    lineWidth: Float,
    @ColorInt lineColor: Int
) {
    this.background = DrawableBuilder()
        .corner(radius)
        .fill(bgColor)
        .line(lineWidth, lineColor)
        .build()
}

/**
 * 设置背景
 * @param bgColor 背景颜色
 * @param radius  圆角半径
 */
fun View.drawableBuilder(
    @ColorInt bgColor: Int,
    radius: Float
) {
    this.background = DrawableBuilder()
        .corner(radius)
        .fill(bgColor)
        .build()
}