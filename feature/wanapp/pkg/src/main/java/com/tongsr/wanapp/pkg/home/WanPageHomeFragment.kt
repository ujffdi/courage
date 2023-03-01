package com.tongsr.wanapp.pkg.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.tongsr.core.base.BaseFragment
import com.tongsr.wanapp.pkg.R

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/24
 * @email ujffdtfivkg@gmail.com
 * @description WanApp 首页
 */
class WanPageHomeFragment : BaseFragment() {

    private val viewModel by viewModels<WanPageHomeViewModel>()

    override fun initData(bundle: Bundle?) {

    }

    override fun onBindLayout(): Int = R.layout.fragment_page_home

    override fun initView(savedInstanceState: Bundle?, contentView: View?) {

    }

    override fun doBusiness() {
    }

    companion object {

        @JvmStatic
        fun newInstance(): WanPageHomeFragment {
            val args = Bundle()
            val fragment = WanPageHomeFragment()
            fragment.arguments = args
            return fragment
        }

    }

}