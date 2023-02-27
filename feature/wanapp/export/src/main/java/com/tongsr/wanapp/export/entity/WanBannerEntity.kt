package com.tongsr.wanapp.export.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/24
 * @email ujffdtfivkg@gmail.com
 * @description 首页Banner
 */
@Parcelize
data class WanBannerEntity(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
) : Parcelable