package com.tongsr.test.pkg

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import by.kirich1409.viewbindingdelegate.viewBinding
import com.therouter.router.Route
import com.tongsr.core.base.BaseActivity
import com.tongsr.core.component.web.WebViewPool
import com.tongsr.test.export.WEB_TEST_PATH
import com.tongsr.test.pkg.databinding.ActivityWebTestBinding

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/3
 * @email ujffdtfivkg@gmail.com
 * @description
 */
@Route(path = WEB_TEST_PATH)
class WebTestActivity : BaseActivity() {

    private val mBinding by viewBinding(ActivityWebTestBinding::bind)

    // 从缓存池获取
    private val mWebView by lazy { WebViewPool.getInstance().getWebView(this) }

    override fun initData(bundle: Bundle?) {

    }

    override fun onBindLayout(): Int = R.layout.activity_web_test

    override fun initView(savedInstanceState: Bundle?, contentView: View?) {
        // 设置生命周期监听
        mWebView.setLifecycleOwner(this)

        mBinding.webContainer.addView(
            mWebView, FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        )

        mWebView.loadUrl("file:android_asset/test_default_bridge.html")

    }

    override fun doBusiness() {

    }

}