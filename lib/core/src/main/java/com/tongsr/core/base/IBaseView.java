package com.tongsr.core.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ThreadUtils;


/**
 * @author Tongsr
 * @version 1.0
 * @date 7/30/21
 * @email ujffdtfivkg@gmail.com
 * @description 基础的方法
 */
public interface IBaseView {

    Handler HANDLER = ThreadUtils.getMainHandler();

    int DELAY_MILLIS = 1000;

    /**
     * 初始化数据，可获取bundle数据或者其他数据
     *
     * @param bundle bundle
     */
    void initData(@Nullable Bundle bundle);

    /**
     * 绑定view layout
     *
     * @return layout id
     */
    int onBindLayout();

    /**
     * 设置View布局
     */
    void setContentView();

    /**
     * 初始化view
     *
     * @param savedInstanceState savedInstanceState
     * @param contentView        contentView
     */
    void initView(@Nullable Bundle savedInstanceState, @Nullable View contentView);

    /**
     * 业务方法
     */
    void doBusiness();

    /**
     * 在主线程执行任务
     * @param runnable runnable
     */
    default void runOnMainThread(Runnable runnable) {
        HANDLER.post(runnable);
    }

    /**
     * 延迟在主线程执行任务，默认1秒
     *
     * @param runnable {@link Runnable}
     */
    default void runOnUiThreadDelayed(Runnable runnable) {
        runOnUiThreadDelayed(DELAY_MILLIS, runnable);
    }

    /**
     * 延迟在主线程执行任务
     *
     * @param runnable    {@link Runnable}
     * @param delayMillis delay millis
     */
    default void runOnUiThreadDelayed(long delayMillis, Runnable runnable) {
        HANDLER.postDelayed(runnable, delayMillis);
    }

}
