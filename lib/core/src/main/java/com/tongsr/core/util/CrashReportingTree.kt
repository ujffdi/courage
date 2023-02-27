package com.tongsr.core.util

import androidx.annotation.NonNull
import timber.log.Timber

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/23
 * @email ujffdtfivkg@gmail.com
 * @description CrashReportingTree
 */
class CrashReportingTree : Timber.Tree() {
    override fun log(
        priority: Int,
        tag: String?,
        @NonNull message: String,
        t: Throwable?
    ) {
        // https://github.com/JakeWharton/timber 做个展示使用。
        // 上传 log 到服务器
        /*if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }
        FakeCrashLibrary.log(priority, tag, message)
        if (t != null) {
            if (priority == Log.ERROR) {
                FakeCrashLibrary.logError(t)
            } else if (priority == Log.WARN) {
                FakeCrashLibrary.logWarning(t)
            }
        }*/
    }
}