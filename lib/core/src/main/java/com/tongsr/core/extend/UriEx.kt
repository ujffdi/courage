package com.tongsr.core.extend

import android.net.Uri
import android.provider.MediaStore

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/1/12
 * @email ujffdtfivkg@gmail.com
 * @description URI
 */

inline val EXTERNAL_MEDIA_IMAGES_URI: Uri
    get() = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

inline val EXTERNAL_MEDIA_VIDEO_URI: Uri
    get() = MediaStore.Video.Media.EXTERNAL_CONTENT_URI