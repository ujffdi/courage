package com.tongsr.core.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tongsr.core.R

/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/11/22
 * @email ujffdtfivkg@gmail.com
 * @description BaseBottomDialogFragment
 */
abstract class BaseBottomDialogFragment: BottomSheetDialogFragment(), IBaseView {

    protected lateinit var mActivity: Activity

    protected lateinit var mContext: Context

    protected lateinit var mContentView: View

    /**
     * 窗口默认半透明
     */
    var mDimAmount: Float = 0.6f

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as Activity
        mContext = context
        setStyle(STYLE_NORMAL, R.style.BaseBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContentView = inflater.inflate(onBindLayout(), container, false)
        initView(savedInstanceState, mContentView)
        return mContentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData(arguments)
        doBusiness()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.let {
            val params: WindowManager.LayoutParams = it.attributes
            params.dimAmount = mDimAmount
            it.attributes = params
        }
    }

    override fun setContentView() {

    }

    /**
     * 禁止点击外部使dialog消失
     */
    open fun setTouchExNoDismiss() {
        dialog?.let {
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
        }
    }

    /**
     * 禁止点击返回键使dialog消失
     */
    open fun setBackNoDismiss() {
        dialog?.let {
            it.setOnKeyListener { _, keyCode, _ ->
                keyCode == KeyEvent.KEYCODE_BACK
            }
        }
    }

    /**
     * 禁止点击外部和返回键使dialog消失
     */
    open fun setTouchExAndBackNoDismiss() {
        dialog?.let {
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            it.setOnKeyListener { _, keyCode, _ ->
                keyCode == KeyEvent.KEYCODE_BACK
            }
        }
    }

}