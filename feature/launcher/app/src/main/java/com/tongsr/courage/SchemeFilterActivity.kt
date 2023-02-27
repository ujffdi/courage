package com.tongsr.courage

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.LogUtils
import com.tongsr.router.routerNavigation


/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/11/25
 * @email ujffdtfivkg@gmail.com
 * @description Scheme 和 Links 的跳转中介
 */
class SchemeFilterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val action: String? = intent?.action
        val data: Uri? = intent?.data
        val url: String? = data?.getQueryParameter("url")

        LogUtils.e(action, data, url)

        // 拿到跳转地址
        url?.let {
            routerNavigation(url)
        }
        finish()
    }

}