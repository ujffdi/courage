package com.tongsr.core.extend.activityresult

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts
import com.tongsr.core.extend.activityresult.MediaUriResultLauncher

/**
 * 注册选择多个图片、视频的启动器
 */
fun ActivityResultCaller.registerForGetMultipleContentsResult(callback: ActivityResultCallback<List<Uri>>) =
  MediaUriResultLauncher(registerForActivityResult(ActivityResultContracts.GetMultipleContents(), callback))
