package com.tongsr.router

import com.therouter.TheRouter


/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/12/15
 * @email ujffdtfivkg@gmail.com
 * @description 路由的初始化。使用教程：https://therouter.cn/
 */

fun setTheRouterDebug(isDebug: Boolean) {
    TheRouter.isDebug = isDebug
}

fun runTask(taskName: String) {
    if (taskName.isBlank()) {
        return
    }
    TheRouter.runTask(taskName)
}