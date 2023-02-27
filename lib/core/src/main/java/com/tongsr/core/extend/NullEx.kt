package com.tongsr.core.extend

/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/11/21
 * @email ujffdtfivkg@gmail.com
 * @description 判空处理
 */

/**
 * 判断是否为null
 *
 * @param value1 value
 * @param bothNotNull block
 */
inline fun <T1> ifNotNull(value1: T1?, bothNotNull: (T1) -> (Unit)) {
    if (value1 != null) {
        bothNotNull(value1)
    }
}

inline fun <T1, T2> ifNotNull(value1: T1?, value2: T2?, bothNotNull: (T1, T2) -> (Unit)) {
    if (value1 != null && value2 != null) {
        bothNotNull(value1, value2)
    }

}

inline fun <T1, T2, T3> ifNotNull(
    value1: T1?,
    value2: T2?,
    value3: T3?,
    bothNotNull: (T1, T2, T3) -> (Unit)
) {
    if (value1 != null && value2 != null && value3 != null) {
        bothNotNull(value1, value2, value3)
    }
}