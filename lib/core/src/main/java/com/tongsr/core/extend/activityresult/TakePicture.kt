package com.tongsr.core.extend.activityresult

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts
import com.tongsr.core.extend.EXTERNAL_MEDIA_IMAGES_URI

/**
 * 注册拍照的启动器
 */
fun ActivityResultCaller.registerForTakePictureResult(callback: ActivityResultCallback<Boolean>) =
    SaveToUriLauncher(
        registerForActivityResult(ActivityResultContracts.TakePicture(), callback),
        EXTERNAL_MEDIA_IMAGES_URI,
        "jpg"
    )
