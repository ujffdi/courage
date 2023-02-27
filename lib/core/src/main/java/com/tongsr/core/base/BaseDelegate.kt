package com.tongsr.core.base

import android.content.Context
import android.view.View
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/11/22
 * @email ujffdtfivkg@gmail.com
 * @description 将一个复杂的页面分成n个Delegate。业务拆分
 */
abstract class BaseDelegate constructor(container: View) : DefaultLifecycleObserver {

    protected var mContainer: View = container

    protected var mContext: Context = container.context

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
    }

}