package com.tongsr.wanapp.pkg.official_accounts

import android.os.Bundle
import android.view.View
import com.tongsr.core.base.BaseFragment
import com.tongsr.wanapp.pkg.R

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/24
 * @email ujffdtfivkg@gmail.com
 * @description WanApp 公众号
 */
class WanOfficialAccountsFragment : BaseFragment() {

    override fun initData(bundle: Bundle?) {

    }

    override fun onBindLayout(): Int = R.layout.fragment_official_accounts

    override fun initView(savedInstanceState: Bundle?, contentView: View?) {

    }

    override fun doBusiness() {

    }

    companion object {

        @JvmStatic
        fun newInstance(): WanOfficialAccountsFragment {
            val args = Bundle()
            val fragment = WanOfficialAccountsFragment()
            fragment.arguments = args
            return fragment
        }

    }

}