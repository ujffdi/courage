@file:Suppress("unused")

package com.tongsr.core.extend.activityresult

import android.Manifest
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.launch
import androidx.annotation.RequiresPermission
import com.tongsr.core.extend.isBluetoothEnabled

/**
 * 注册开启蓝牙的启动器
 */
@RequiresPermission(Manifest.permission.BLUETOOTH)
fun ActivityResultCaller.registerForEnableBluetoothResult(
    onLocationDisabled: LocationScope.() -> Unit,
    onBluetoothEnabled: BluetoothScope.(Boolean) -> Unit
): ActivityResultLauncher<Unit> {
  val enableBluetoothLauncher = registerForEnableBluetoothResult(onBluetoothEnabled)
  val enableLocationLauncher = registerForEnableLocationResult { enabled ->
    if (enabled) {
      enableBluetoothLauncher.launch()
    } else {
      onLocationDisabled(this)
    }
  }
  return enableLocationLauncher
}

@RequiresPermission(Manifest.permission.BLUETOOTH)
fun ActivityResultCaller.registerForEnableBluetoothResult(
  onBluetoothEnabled: BluetoothScope.(Boolean) -> Unit
): ActivityResultLauncher<Unit> {
  var enableBluetoothLauncher: ActivityResultLauncher<Unit>? = null
  enableBluetoothLauncher = registerForActivityResult(EnableBluetoothContract()) {
    onBluetoothEnabled(BluetoothScope { enableBluetoothLauncher?.launch() }, it)
  }
  return enableBluetoothLauncher
}

class EnableBluetoothContract : ActivityResultContract<Unit, Boolean>() {

  override fun createIntent(context: Context, input: Unit) =
    Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)

  override fun parseResult(resultCode: Int, intent: Intent?) =
    resultCode == Activity.RESULT_OK

  override fun getSynchronousResult(context: Context, input: Unit): SynchronousResult<Boolean>? =
    if (isBluetoothEnabled) SynchronousResult(true) else null
}

fun interface BluetoothScope {
  fun enableBluetooth()
}
