package com.tongsr.data.remote.exception

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/27
 * @email ujffdtfivkg@gmail.com
 * @description ApiException
 */
class ApiException constructor(val code: Int, message: String) :
    RuntimeException(message)