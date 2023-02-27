package com.tongsr.wanapp.pkg.main

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.blankj.utilcode.util.BarUtils
import com.therouter.router.Route
import com.tongsr.core.base.BaseActivity
import com.tongsr.wanapp.export.WAN_HOME_PATH
import com.tongsr.wanapp.pkg.R
import com.tongsr.wanapp.pkg.databinding.ActivityWanMainBinding


/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/12/6
 * @email ujffdtfivkg@gmail.com
 * @description
 */
@Route(path = WAN_HOME_PATH)
class WanMainActivity : BaseActivity() {

    private val mBinding by viewBinding(ActivityWanMainBinding::bind)

    private val navController = NavInitController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BarUtils.setStatusBarLightMode(this, true)
    }

    override fun initData(bundle: Bundle?) {

    }

    override fun onBindLayout(): Int = R.layout.activity_wan_main

    override fun initView(savedInstanceState: Bundle?, contentView: View?) {

    }

    override fun onStart() {
        super.onStart()
        if (navController.isUnInit()) {
            // 这么做是因为 onCreate() 方法调用 findNavController 会报错。时机还不对
            initNavigation()
            navController.init()
        }
    }

    override fun doBusiness() {
        showPrivacyPolicyDialog()
    }

    private fun initNavigation() {
        val navController = findNavController(R.id.nav_host_fragment)
        /*val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.wanHomeFragment,
                R.id.wanSquareFragment,
                R.id.wanOfficialAccountsFragment,
                R.id.wanSystemFragment,
                R.id.wanProjectFragment
            )
        )*/
        // menu_bottom_nav 文件和 nav_graph 文件里的 id 要一致，不然无法点击切换
        // 原因看源代码 ↓
        mBinding.navigationView.setupWithNavController(navController)
        //setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun showPrivacyPolicyDialog() {
        val privacyPolicyDialog = PrivacyPolicyDialog.newInstance().apply {
            mDimAmount = 0F
        }
        privacyPolicyDialog.show(supportFragmentManager, PrivacyPolicyDialog.TAG)
    }

}