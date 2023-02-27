package com.tongsr.core.extend.activityresult

import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts

/**
 * 注册 startIntentSenderForResult() 的启动器
 *
 * @param callback ActivityResultCallback
 */
fun ActivityResultCaller.registerForStartIntentSenderResult(callback: ActivityResultCallback<ActivityResult>) =
  registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult(), callback)
