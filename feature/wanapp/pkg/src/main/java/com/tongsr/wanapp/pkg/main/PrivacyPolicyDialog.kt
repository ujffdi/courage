package com.tongsr.wanapp.pkg.main

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.blankj.utilcode.util.ShadowUtils
import com.tongsr.core.base.BaseDialogFragment
import com.tongsr.core.extend.dp
import com.tongsr.router.runTask
import com.tongsr.wanapp.pkg.PRIVACY_POLICY_TEST_INIT
import com.tongsr.wanapp.pkg.R
import com.tongsr.wanapp.pkg.databinding.DialogPrivacyPolicyBinding

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/23
 * @email ujffdtfivkg@gmail.com
 * @description 模拟隐私协议通过后才初始化某些方法
 */
class PrivacyPolicyDialog : BaseDialogFragment() {


    private val mBinging by viewBinding(DialogPrivacyPolicyBinding::bind)

    override fun initData(bundle: Bundle?) {

    }

    override fun onBindLayout(): Int = R.layout.dialog_privacy_policy

    override fun initView(savedInstanceState: Bundle?, contentView: View?) {
        if (contentView != null) {
            ShadowUtils.apply(
                contentView,
                ShadowUtils.Config().setShadowColor(0x44000000, 0x55000000)
                    .setShadowSize(6)
                    .setShadowRadius(6.dp)
            )
        }
    }

    override fun doBusiness() {
        mBinging.tvConfirm.setOnClickListener {
            // TODO 模拟隐私协议通过后才初始化某些方法
            dismiss()
            runTask(PRIVACY_POLICY_TEST_INIT)
        }
        mBinging.tvCancel.setOnClickListener {
            dismiss()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(): PrivacyPolicyDialog = PrivacyPolicyDialog()

        val TAG: String = PrivacyPolicyDialog::class.java.simpleName

    }

}