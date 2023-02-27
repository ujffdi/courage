package com.tongsr.core.extend.activityresult

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts

/**
 * 注册创建文档的启动器
 *
 * @param callback ActivityResultCallback<Uri?>
 */
fun ActivityResultCaller.registerForCreateDocumentResult(callback: ActivityResultCallback<Uri?>) =
  registerForActivityResult(ActivityResultContracts.CreateDocument("image/png"), callback)
