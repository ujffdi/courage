package com.tongsr.wanapp.pkg.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tongsr.core.base.BaseViewModel
import com.tongsr.wanapp.export.entity.WanBannerEntity
import com.tongsr.wanapp.export.repository.WanPageHomeProvider

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/23
 * @email ujffdtfivkg@gmail.com
 * @description WanPageHomeViewModel
 */
class WanPageHomeViewModel : BaseViewModel() {

    private val wanPageHomeProvider = WanPageHomeProvider()

    private val _banner = MutableLiveData<List<WanBannerEntity>>()
    val banner: LiveData<List<WanBannerEntity>> = _banner

    fun getBannerData() {

    }

}