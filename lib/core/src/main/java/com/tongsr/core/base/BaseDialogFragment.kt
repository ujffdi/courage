package com.tongsr.core.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatDialogFragment
import com.blankj.utilcode.util.ScreenUtils
import com.tongsr.core.R
import com.tongsr.core.extend.dp

/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/11/21
 * @email ujffdtfivkg@gmail.com
 * @description BaseDialogFragment
 */
abstract class BaseDialogFragment : AppCompatDialogFragment(), IBaseView {

    /*
        解决DialogFragment宽度问题有以下方案：
        1.XML嵌套一层布局（不推荐）
        2.调用dialog?.window?.setLayout(-1,-2)
        3.拿到window的LayoutParams对宽高进行修改

        本例子采用第三种方法
        val dialog = TestDialog.newInstance().apply {
                mDimAmount = 0F
                mGravity = Gravity.BOTTOM
                ...
        }
        dialog.show(supportFragmentManager, "test")
     */

    protected lateinit var mActivity: Activity

    protected lateinit var mContext: Context

    protected lateinit var mContentView: View

    /**
     * 默认竪屏3/4的屏幕宽度，橫屏狀態300dp
     */
    var mWidth: Int = (ScreenUtils.getAppScreenWidth() * 0.75).toInt()

    /**
     * 默认自适应高度
     */
    var mHeight: Int = ViewGroup.LayoutParams.WRAP_CONTENT

    /**
     * 默认居中
     */
    var mGravity: Int = Gravity.CENTER

    /**
     * 显示和隐藏动画
     */
    var mWindowAnimations: Int = R.style.DialogDefaultAnimation

    /**
     * 窗口默认半透明
     */
    var mDimAmount: Float = 0.6f

    /**
     * 背景默认不透明
     */
    var mAlpha: Float = 1f

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as Activity
        mContext = context
        setStyle(STYLE_NO_TITLE, R.style.BaseDialogTheme)
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
            params.width = mWidth
            params.height = mHeight
            params.gravity = mGravity
            params.windowAnimations = mWindowAnimations
            params.dimAmount = mDimAmount
            params.alpha = mAlpha
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