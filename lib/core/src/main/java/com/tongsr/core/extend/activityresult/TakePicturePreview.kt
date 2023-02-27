package com.tongsr.core.extend.activityresult

import android.graphics.Bitmap
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts

/**
 * 注册拍照预览的启动器
 *
 * @param callback ActivityResultCallback
 */
fun ActivityResultCaller.registerForTakePicturePreviewResult(callback: ActivityResultCallback<Bitmap?>) =
  registerForActivityResult(ActivityResultContracts.TakePicturePreview(), callback)
