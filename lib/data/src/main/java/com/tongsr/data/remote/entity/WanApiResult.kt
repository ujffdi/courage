package com.tongsr.data.remote.entity

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/24
 * @email ujffdtfivkg@gmail.com
 * @description WanApp 最外层数据结构
 */

data class WanApiResult<T>(val data: T, val errorCode: Int, val errorMsg: String)