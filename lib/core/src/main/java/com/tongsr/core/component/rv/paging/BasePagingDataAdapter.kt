package com.tongsr.core.component.rv.paging

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.tongsr.core.component.rv.holder.BaseViewHolder

/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/6/23
 * @email ujffdtfivkg@gmail.com
 * @description 基于 Paging3 封装的 Adapter
 */
abstract class BasePagingDataAdapter<T : Any, VH : BaseViewHolder> constructor(diffCallback: DiffUtil.ItemCallback<T>) :
    PagingDataAdapter<T, VH>(diffCallback) {

    override fun onBindViewHolder(holder: VH, position: Int) {
        onBindBaseViewHolder(holder, getItem(position))
    }

    override fun onBindViewHolder(holder: VH, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position)
            return
        }
        onBindBaseViewHolder(holder, getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return onCreateBaseViewHolder(parent, viewType)
    }

    abstract fun onCreateBaseViewHolder(parent: ViewGroup, viewType: Int): VH

    abstract fun onBindBaseViewHolder(holder: VH, item: T?)

}