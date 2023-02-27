package com.tongsr.router

import android.app.Activity
import android.os.Bundle
import android.os.Parcelable
import androidx.core.app.ActivityOptionsCompat
import com.therouter.TheRouter
import com.therouter.router.Navigator
import com.therouter.router.interceptor.NavigationCallback
import java.io.Serializable

/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/11/13
 * @email ujffdtfivkg@gmail.com
 * @description ARouter 的封装
 */

/**
 * 标准使用
 * @path 路由路径
 * @params 所传参数
 */
fun routerNavigation(path: String, params: Map<String, Any>? = null) {
    buildParams(TheRouter.build(path), params).navigation()
}

/**
 * 解析params放到Postcard中
 */
private fun buildParams(navigator: Navigator, params: Map<String, Any>?): Navigator {
    return navigator.apply {
        if (params != null && params.isNotEmpty())
            for ((k, v) in params)
                when (v) {
                    is String -> withString(k, v)
                    is Int -> withInt(k, v)
                    is Boolean -> withBoolean(k, v)
                    is Long -> withLong(k, v)
                    is Float -> withFloat(k, v)
                    is Double -> withDouble(k, v)
                    is Byte -> withByte(k, v)
                    is ByteArray -> navigator.fillParams { it.putByteArray(k, v) }
                    is Bundle -> navigator.fillParams { it.putAll(v) }
                    is List<*>, is Map<*, *>, is Set<*> -> withObject(k, v)
                    is Parcelable -> withParcelable(k, v)
                    is Serializable -> withSerializable(k, v)
                    else -> withObject(k, v)
                }
    }
}

/**
 * 进阶使用方法
 * @path 路由路径
 * @params 所传参数
 * @activity 当前activity，配合requestCode或callback使用
 * @requestCode 当需要startActivityForResult时
 * @callback 使用NavigationCallback处理跳转结果
 * @group 一般不传，默认就是 path 的第一段相同
 * @flag 当需要指定flag时Intent.FLAG_ACTIVITY_CLEAR_TOP
 * @enterAnim 页面进入动画
 * @exitAnim 页面退出动画
 * @compat ActivityOptionsCompat动画
 */
fun routerNavigation(
    path: String,
    params: Map<String, Any>? = null,
    activity: Activity? = null,
    requestCode: Int = -1,
    callback: NavigationCallback? = null,
    flag: Int? = null,
    enterAnim: Int? = null,
    exitAnim: Int? = null,
    compat: ActivityOptionsCompat? = null,
) {
    if (path.isEmpty()) {
        return
    }
    val navigator = TheRouter.build(path)
    buildParams(
        navigator.apply {
            if (flag != null)
                this.withFlags(flag)
            if (enterAnim != null)//转场动画(常规方式)
                this.withInAnimation(enterAnim)
            if (exitAnim != null)//转场动画(常规方式)
                this.withOutAnimation(exitAnim)
            if (compat != null)// 转场动画(API16+)
                navigator.withOptionsCompat(compat.toBundle())
        }, params
    ).navigation(activity, requestCode, callback)
}