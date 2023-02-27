package com.tongsr.core.extend.activityresult

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContract

/**
 * 注册选择单个图片、视频的启动器
 */
fun ActivityResultCaller.registerForPickContentResult(callback: ActivityResultCallback<Uri>) =
  MediaUriResultLauncher(registerForActivityResult(PickContentContract(), callback))

class PickContentContract : ActivityResultContract<String, Uri>() {

  override fun createIntent(context: Context, input: String) =
    Intent(Intent.ACTION_PICK).setType(input)

  override fun parseResult(resultCode: Int, intent: Intent?): Uri {
    return if (intent == null || resultCode != Activity.RESULT_OK) Uri.EMPTY else intent.data!!
  }

}
