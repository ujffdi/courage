package com.tongsr.core.component.rv.business

import android.view.LayoutInflater
import android.view.ViewGroup
import com.tongsr.core.component.rv.holder.BaseViewHolder
import com.tongsr.core.component.rv.getLayoutInflater

/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/8/10
 * @email ujffdtfivkg@gmail.com
 * @description 实现传递 LayoutInflater
 */
abstract class BusinessBinderAdapter<T, VH : BaseViewHolder> @JvmOverloads constructor(
    data: MutableList<T>? = null
) : BusinessAdapter<T, VH>(data) {

    override fun onCreateBaseViewHolder(parent: ViewGroup, viewType: Int): VH {
        return onCreateBaseViewHolder(parent.getLayoutInflater(), parent)
    }

    abstract fun onCreateBaseViewHolder(inflater: LayoutInflater, parent: ViewGroup): VH

}