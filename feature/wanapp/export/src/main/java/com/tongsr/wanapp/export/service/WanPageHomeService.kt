package com.tongsr.wanapp.export.service

import com.tongsr.data.remote.entity.WanPage
import com.tongsr.data.remote.entity.WanApiResult
import com.tongsr.wanapp.export.entity.WanArticleEntity
import com.tongsr.wanapp.export.entity.WanBannerEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/22
 * @email ujffdtfivkg@gmail.com
 * @description 首页
 */
interface WanPageHomeService {

    /**
     * 获取首页文章列表
     *
     * @param page page
     */
    @GET("/article/list/{page}/json")
    fun getHomeArticleListData(@Path("page") page: Int): Flow<WanApiResult<WanPage<WanArticleEntity>>>

    /**
     * 获取首页Banner
     */
    @GET("/banner/json")
    fun getBannerData(): Flow<WanApiResult<List<WanBannerEntity>>>


}