package com.tongsr.core.extend.activityresult

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts
import com.tongsr.core.extend.EXTERNAL_MEDIA_VIDEO_URI

/**
 * 注册录像的启动器
 */
fun ActivityResultCaller.registerForTakeVideoResult(callback: ActivityResultCallback<Boolean>) =
  SaveToUriLauncher(registerForActivityResult(ActivityResultContracts.CaptureVideo(), callback), EXTERNAL_MEDIA_VIDEO_URI, "mp4")
