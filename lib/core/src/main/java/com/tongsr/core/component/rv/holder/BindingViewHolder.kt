package com.tongsr.core.component.rv.holder

import androidx.viewbinding.ViewBinding

/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/8/10
 * @email ujffdtfivkg@gmail.com
 * @description 基于 ViewBinding 以及 BaseViewHolder
 */
class BindingViewHolder<VB : ViewBinding>(val binding: VB) : BaseViewHolder(binding.root)