package com.tongsr.wanapp.pkg.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.LogUtils
import com.tongsr.core.base.BaseViewModel
import com.tongsr.core.base.executeRequest
import com.tongsr.data.remote.NetworkClient
import com.tongsr.wanapp.export.entity.WanBannerEntity
import com.tongsr.wanapp.export.provider.WanPageHomeProvider
import com.tongsr.wanapp.export.service.WanPageHomeService
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

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