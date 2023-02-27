package com.tongsr.core.component.rv.business

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.tongsr.core.component.rv.holder.BindingViewHolder

/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/8/10
 * @email ujffdtfivkg@gmail.com
 * @description 基于 ViewBinding 的 Adapter
 */
abstract class ViewBindingAdapter<T, VB : ViewBinding> @JvmOverloads constructor(data: MutableList<T>? = null) :
    BusinessBinderAdapter<T, BindingViewHolder<VB>>(data) {

    override fun onCreateBaseViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): BindingViewHolder<VB> {
        return BindingViewHolder(onBinding(inflater, parent))
    }

    /**
     * 不想使用反射
     */
    abstract fun onBinding(inflater: LayoutInflater, parent: ViewGroup): VB

}