package com.tongsr.core.extend.activityresult

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts

/**
 * 注册选择联系人的启动器
 */
fun ActivityResultCaller.registerForPickContactResult(callback: ActivityResultCallback<Uri?>) =
  registerForActivityResult(ActivityResultContracts.PickContact(), callback)
