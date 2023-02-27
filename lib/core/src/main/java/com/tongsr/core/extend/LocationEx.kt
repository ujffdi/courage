package com.tongsr.core.extend

import android.location.LocationManager
import androidx.core.content.getSystemService
import com.blankj.utilcode.util.Utils

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/1/12
 * @email ujffdtfivkg@gmail.com
 * @description Location
 */


inline val isLocationEnabled: Boolean
    get() = try {
        Utils.getApp().getSystemService<LocationManager>()?.isProviderEnabled(LocationManager.GPS_PROVIDER) == true
    } catch (e: Exception) {
        false
    }