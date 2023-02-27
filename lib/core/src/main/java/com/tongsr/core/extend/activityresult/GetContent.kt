package com.tongsr.core.extend.activityresult

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts

/**
 * 注册选择单个图片、视频的启动器
 */
fun ActivityResultCaller.registerForGetContentResult(callback: ActivityResultCallback<Uri?>) =
  MediaUriResultLauncher(registerForActivityResult(ActivityResultContracts.GetContent(), callback))
