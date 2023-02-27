package com.tongsr.wanapp.pkg.project

import android.os.Bundle
import android.view.View
import com.tongsr.core.base.BaseFragment
import com.tongsr.wanapp.pkg.R

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/24
 * @email ujffdtfivkg@gmail.com
 * @description WanApp 项目
 */
class WanProjectFragment : BaseFragment() {

    override fun initData(bundle: Bundle?) {

    }

    override fun onBindLayout(): Int = R.layout.fragment_project

    override fun initView(savedInstanceState: Bundle?, contentView: View?) {

    }

    override fun doBusiness() {

    }

    companion object {

        @JvmStatic
        fun newInstance(): WanProjectFragment {
            val args = Bundle()
            val fragment = WanProjectFragment()
            fragment.arguments = args
            return fragment
        }

    }

}