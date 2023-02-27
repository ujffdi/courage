package com.tongsr.core.extend.activityresult

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts


/**
 * 注册打开文档目录的启动器
 */
fun ActivityResultCaller.registerForOpenDocumentTreeResult(callback: ActivityResultCallback<Uri?>) =
  registerForActivityResult(ActivityResultContracts.OpenDocumentTree(), callback)
