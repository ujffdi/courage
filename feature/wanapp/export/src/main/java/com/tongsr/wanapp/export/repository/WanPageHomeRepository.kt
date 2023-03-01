package com.tongsr.wanapp.export.repository

import com.tongsr.data.remote.NetworkClient
import com.tongsr.data.remote.entity.WanApiResult
import com.tongsr.data.remote.entity.WanPage
import com.tongsr.wanapp.export.entity.WanArticleEntity
import com.tongsr.wanapp.export.entity.WanBannerEntity
import com.tongsr.wanapp.export.service.WanPageHomeService
import kotlinx.coroutines.flow.Flow

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/25
 * @email ujffdtfivkg@gmail.com
 * @description WanApp 首页数据提供者
 */
class WanPageHomeRepository : WanPageHomeApi {

    private val wanPageHomeService = NetworkClient.wanApiClient.create(WanPageHomeService::class.java)

    override fun getHomeArticleListData(page: Int): Flow<WanApiResult<WanPage<WanArticleEntity>>> =
        wanPageHomeService.getHomeArticleListData(page)

    override fun getBannerData(): Flow<WanApiResult<List<WanBannerEntity>>> =
        wanPageHomeService.getBannerData()

}

interface WanPageHomeApi {

    fun getHomeArticleListData(page: Int): Flow<WanApiResult<WanPage<WanArticleEntity>>>

    fun getBannerData(): Flow<WanApiResult<List<WanBannerEntity>>>

}