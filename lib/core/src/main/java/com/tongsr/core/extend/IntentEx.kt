package com.tongsr.core.extend

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.core.os.bundleOf

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/1/12
 * @email ujffdtfivkg@gmail.com
 * @description Intent
 */

inline fun <reified T> Context.intentOf(vararg pairs: Pair<String, *>): Intent =
    intentOf<T>(bundleOf(*pairs))

inline fun <reified T> Context.intentOf(bundle: Bundle): Intent =
    Intent(this, T::class.java).putExtras(bundle)

fun Intent.grantReadUriPermission(): Intent = apply {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    }
}