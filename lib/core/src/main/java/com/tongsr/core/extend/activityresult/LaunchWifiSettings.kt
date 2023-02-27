package com.tongsr.core.extend.activityresult

import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContract

/**
 * 注册启动 Wifi 设置页的启动器
 *
 * @param callback ActivityResultCallback
 */
fun ActivityResultCaller.registerForLaunchWifiSettingsResult(callback: ActivityResultCallback<Unit>) =
  registerForActivityResult(LaunchWifiSettingsContract(), callback)

class LaunchWifiSettingsContract : ActivityResultContract<Unit, Unit>() {

  override fun createIntent(context: Context, input: Unit) =
    Intent(Settings.ACTION_WIFI_SETTINGS)

  override fun parseResult(resultCode: Int, intent: Intent?) = Unit

}
