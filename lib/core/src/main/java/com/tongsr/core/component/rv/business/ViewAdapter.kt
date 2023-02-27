package com.tongsr.core.component.rv.business

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.tongsr.core.R
import com.tongsr.core.component.rv.holder.BaseViewHolder

/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/8/9
 * @email ujffdtfivkg@gmail.com
 * @description 当使用 ConcatAdapter 时，某个 Adapter 恰巧是一个 View
 */
abstract class ViewAdapter<T, V : View> @JvmOverloads constructor(data: MutableList<T>? = null) :
    BusinessAdapter<T, ViewAdapter.Holder<V>>(data) {

    protected val View.holder: Holder<V>
        get() {
            return holder(this)
                ?: throw IllegalAccessException("The view holder property can only be called after onCreateView()!")
        }

    protected val View.layoutPosition: Int get() = holder.layoutPosition

    protected val View.absoluteAdapterPosition: Int get() = holder.absoluteAdapterPosition

    protected val View.bindingAdapterPosition: Int get() = holder.bindingAdapterPosition

    class Holder<V : View>(val view: V) : BaseViewHolder(view)

    override fun onCreateBaseViewHolder(parent: ViewGroup, viewType: Int): Holder<V> {
        return Holder(onCreateView(parent.context, parent))
    }

    override fun onBindBaseViewHolder(holder: Holder<V>, item: T) {
        onBindView(holder, holder.view, item)
    }

    abstract fun onCreateView(context: Context): V

    abstract fun onBindView(view: V, item: T)

    // Override this function if you need a parent ViewGroup
    open fun onCreateView(context: Context, parent: ViewGroup): V {
        return onCreateView(context)
    }

    // Override this function if you need a ViewHolder or positions
    open fun onBindView(holder: Holder<V>, view: V, item: T) {
        view.setTag(R.id.tagViewHolder, holder)
        onBindView(view, item)
    }

    @Suppress("UNCHECKED_CAST")
    private fun holder(view: View): Holder<V>? {
        return view.getTag(R.id.tagViewHolder) as? Holder<V>
    }

}