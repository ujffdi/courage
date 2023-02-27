package com.tongsr.core.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import org.jetbrains.annotations.NotNull


/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/11/21
 * @email ujffdtfivkg@gmail.com
 * @description BaseFragment
 */
abstract class BaseFragment : Fragment(), IBaseView {

    protected lateinit var mActivity: Activity
    protected lateinit var mContext: Context
    protected lateinit var mInflater: LayoutInflater
    protected var mContentView: View? = null
    protected var mContainer: ViewGroup? = null
    private var isLoaded = false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as Activity
        mContext = context
    }

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData(arguments)
    }

    @Nullable
    override fun onCreateView(
        @NotNull inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        mInflater = inflater
        if (container != null) {
            this.mContainer = container
        }
        setContentView()
        initView(savedInstanceState, mContentView)
        return mContentView
    }

    override fun setContentView() {
        if (onBindLayout() <= 0 || mContainer == null) {
            return
        }
        mContentView = mInflater.inflate(onBindLayout(), mContainer, false)
    }

    override fun onResume() {
        super.onResume()
        if (!isLoaded && !isHidden) {
            onLazyInitView()
            isLoaded = true
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doBusiness()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isLoaded = false
    }

    /**
     * 懒加载
     */
    protected open fun onLazyInitView() {

    }

}