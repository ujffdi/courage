package com.tongsr.wanapp.pkg.system

import android.os.Bundle
import android.view.View
import com.tongsr.core.base.BaseFragment
import com.tongsr.wanapp.pkg.R

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/24
 * @email ujffdtfivkg@gmail.com
 * @description WanApp 体系
 */
class WanSystemFragment : BaseFragment() {

    override fun initData(bundle: Bundle?) {

    }

    override fun onBindLayout(): Int = R.layout.fragment_system

    override fun initView(savedInstanceState: Bundle?, contentView: View?) {

    }

    override fun doBusiness() {

    }

    companion object {

        @JvmStatic
        fun newInstance(): WanSystemFragment {
            val args = Bundle()
            val fragment = WanSystemFragment()
            fragment.arguments = args
            return fragment
        }

    }

}