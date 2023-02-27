package com.tongsr.wanapp.pkg.main

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/24
 * @email ujffdtfivkg@gmail.com
 * @description Navigation 初始化控制，防止生命周期变化导致多次初始化
 */

data class NavInitController(private var init: Boolean = false) {

    fun isUnInit(): Boolean = !init

    fun init() {
        init = true
    }

}