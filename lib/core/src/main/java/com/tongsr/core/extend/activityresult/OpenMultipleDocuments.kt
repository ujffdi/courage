package com.tongsr.core.extend.activityresult

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts

/**
 * 注册打开多个文档的启动器
 */
fun ActivityResultCaller.registerForOpenMultipleDocumentsResult(callback: ActivityResultCallback<List<Uri>>) =
  registerForActivityResult(ActivityResultContracts.OpenMultipleDocuments(), callback)
