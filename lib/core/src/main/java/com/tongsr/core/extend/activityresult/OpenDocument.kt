package com.tongsr.core.extend.activityresult

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts

/**
 * 注册打开单个文档的启动器
 */
fun ActivityResultCaller.registerForOpenDocumentResult(callback: ActivityResultCallback<Uri?>) =
  registerForActivityResult(ActivityResultContracts.OpenDocument(), callback)
