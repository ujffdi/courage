package com.tongsr.core.component.rv.business

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.annotation.IntRange
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.tongsr.core.component.rv.holder.BaseViewHolder

/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/7/6
 * @email ujffdtfivkg@gmail.com
 * @description 使用 ConcatAdapter 时，由多个 RecyclerView.Adapter 组成。定义为「业务」Adapter；
 */
abstract class BusinessAdapter<T, VH : BaseViewHolder> @JvmOverloads constructor(
    data: MutableList<T>? = null
) : RecyclerView.Adapter<VH>() {

    /**
     * data, Only allowed to get.
     * 数据, 只允许 get。
     */
    var data: MutableList<T> = data ?: mutableListOf()
        internal set

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        onCreateBaseViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: VH, position: Int) {
        onBindBaseViewHolder(holder, data[position])
    }

    override fun onBindViewHolder(holder: VH, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position)
            return
        }
        onBindBaseViewHolder(holder, data[position])
    }

    override fun getItemCount(): Int = data.size

    abstract fun onCreateBaseViewHolder(parent: ViewGroup, viewType: Int): VH

    abstract fun onBindBaseViewHolder(holder: VH, item: T)

    /*************************** 设置数据相关 ******************************************/

    /**
     * setting up a new instance to data;
     * 设置新的数据实例
     *
     * @param data
     */
    @Deprecated(
        "Please use setNewInstance(), This method will be removed in the next version",
        replaceWith = ReplaceWith("setNewInstance(data)")
    )
    open fun setNewData(data: MutableList<T>?) {
        setNewInstance(data)
    }

    /**
     * setting up a new instance to data;
     * 设置新的数据实例，替换原有内存引用。
     * 通常情况下，如非必要，请使用[setList]修改内容
     *
     * @param list
     */
    @SuppressLint("NotifyDataSetChanged")
    open fun setNewInstance(list: MutableList<T>?) {
        if (list === this.data) {
            return
        }
        this.data = list ?: arrayListOf()
        notifyDataSetChanged()
    }

    /**
     * use data to replace all item in mData. this method is different [setList],
     * it doesn't change the [BusinessAdapter.data] reference
     * Deprecated, Please use [setList]
     *
     * @param newData data collection
     */
    @Deprecated("Please use setData()", replaceWith = ReplaceWith("setList(newData)"))
    open fun replaceData(newData: Collection<T>) {
        setList(newData)
    }

    /**
     * 使用新的数据集合，改变原有数据集合内容。
     * 注意：不会替换原有的内存引用，只是替换内容
     *
     * @param list Collection<T>?
     */
    @SuppressLint("NotifyDataSetChanged")
    open fun setList(list: Collection<T>?) {
        if (list !== this.data) {
            this.data.clear()
            if (!list.isNullOrEmpty()) {
                this.data.addAll(list)
            }
        } else {
            if (!list.isNullOrEmpty()) {
                val newList = ArrayList(list)
                this.data.clear()
                this.data.addAll(newList)
            } else {
                this.data.clear()
            }
        }
        notifyDataSetChanged()
    }

    /**
     * change data
     * 改变某一位置数据
     */
    open fun setData(@IntRange(from = 0) index: Int, data: T) {
        if (index >= this.data.size) {
            return
        }
        this.data[index] = data
        notifyItemChanged(index)
    }

    /**
     * add one new data in to certain location
     * 在指定位置添加一条新数据
     *
     * @param position
     */
    open fun addData(@IntRange(from = 0) position: Int, data: T) {
        this.data.add(position, data)
        notifyItemInserted(position)
        compatibilityDataSizeChanged(1)
    }

    /**
     * add one new data
     * 添加一条新数据
     */
    open fun addData(@NonNull data: T) {
        this.data.add(data)
        notifyItemInserted(this.data.size)
        compatibilityDataSizeChanged(1)
    }

    /**
     * add new data in to certain location
     * 在指定位置添加数据
     *
     * @param position the insert position
     * @param newData  the new data collection
     */
    open fun addData(@IntRange(from = 0) position: Int, newData: Collection<T>) {
        this.data.addAll(position, newData)
        notifyItemRangeInserted(position, newData.size)
        compatibilityDataSizeChanged(newData.size)
    }

    open fun addData(@NonNull newData: Collection<T>) {
        this.data.addAll(newData)
        notifyItemRangeInserted(this.data.size - newData.size, newData.size)
        compatibilityDataSizeChanged(newData.size)
    }

    /**
     * remove the item associated with the specified position of adapter
     * 删除指定位置的数据
     *
     * @param position
     */
    @Deprecated("Please use removeAt()", replaceWith = ReplaceWith("removeAt(position)"))
    open fun remove(@IntRange(from = 0) position: Int) {
        removeAt(position)
    }

    /**
     * remove the item associated with the specified position of adapter
     * 删除指定位置的数据
     *
     * @param position
     */
    open fun removeAt(@IntRange(from = 0) position: Int) {
        if (position >= data.size) {
            return
        }
        this.data.removeAt(position)
        notifyItemRemoved(position)
        compatibilityDataSizeChanged(0)
        notifyItemRangeChanged(position, this.data.size - position)
    }

    open fun remove(data: T) {
        val index = this.data.indexOf(data)
        if (index == -1) {
            return
        }
        removeAt(index)
    }

    /**
     * compatible getLoadMoreViewCount and getEmptyViewCount may change
     *
     * @param size Need compatible data size
     */
    @SuppressLint("NotifyDataSetChanged")
    protected fun compatibilityDataSizeChanged(size: Int) {
        if (this.data.size == size) {
            notifyDataSetChanged()
        }
    }

}