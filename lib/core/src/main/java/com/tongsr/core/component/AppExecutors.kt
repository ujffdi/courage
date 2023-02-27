package com.tongsr.core.component

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors


/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/1/25
 * @email ujffdtfivkg@gmail.com
 * @description 不想用太复杂的线程池，就用当前的AppExecutors
 */
object AppExecutors {

    private val mDiskIO by lazy {
        Executors.newSingleThreadExecutor()
    }

    private val mNetworkIO by lazy {
        Executors.newFixedThreadPool(3)
    }

    private val mMainThread by lazy {
        MainThreadExecutor()
    }

    fun diskIO(): Executor {
        return mDiskIO
    }

    fun networkIO(): Executor {
        return mNetworkIO
    }

    fun mainThread(): Executor {
        return mMainThread
    }

    private class MainThreadExecutor : Executor {

        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }

    }

}