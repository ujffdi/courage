@file:Suppress("unused")

package com.tongsr.core.extend.activityresult

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.core.app.ActivityCompat
import com.blankj.utilcode.util.ActivityUtils


/**
 * 注册请求多个权限的启动器
 */
fun ActivityResultCaller.registerForRequestMultiplePermissionsResult(
    onAllGranted: () -> Unit,
    onDenied: AppSettingsScope.(List<String>) -> Unit,
    onShowRequestRationale: PermissionsScope.(List<String>) -> Unit
): ActivityResultLauncher<Array<String>> {
  var permissionsLauncher: ActivityResultLauncher<Array<String>>? = null
  val deniedList = mutableListOf<String>()
  val launchAppSettingsLauncher = registerForLaunchAppSettingsResult {
    permissionsLauncher?.launch(deniedList.toTypedArray())
  }
  permissionsLauncher = registerForRequestMultiplePermissionsResult { result ->
    if (result.containsValue(false)) {
      deniedList.clear()
      deniedList.addAll(result.asIterable().filter { !it.value }.map { it.key })
      val explainableList = deniedList.filter {
        ActivityCompat.shouldShowRequestPermissionRationale(ActivityUtils.getTopActivity(), it)
      }
      if (explainableList.isNotEmpty()) {
        onShowRequestRationale(PermissionsScope {
          permissionsLauncher?.launch(explainableList.toTypedArray())
        }, explainableList)
      } else {
        onDenied(AppSettingsScope { launchAppSettingsLauncher.launch() }, deniedList)
      }
    } else {
      onAllGranted()
    }
  }
  return permissionsLauncher
}

fun ActivityResultCaller.registerForRequestMultiplePermissionsResult(callback: ActivityResultCallback<Map<String, Boolean>>) =
  registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions(), callback)

fun interface PermissionsScope {
  fun requestDeniedPermissions()
}
