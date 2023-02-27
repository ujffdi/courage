package com.tongsr.wanapp.pkg

import android.app.Application
import android.content.Context
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.blankj.utilcode.util.Utils
import com.therouter.app.flowtask.lifecycle.FlowTask
import com.therouter.flow.TheRouterFlowTask
import com.tongsr.core.BuildConfig
import com.tongsr.core.R
import com.tongsr.core.component.web.TemplateWebViewPool
import com.tongsr.core.component.web.WebViewPool
import com.tongsr.core.util.CrashReportingTree
import timber.log.Timber
import java.lang.Integer.min


/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/3
 * @email ujffdtfivkg@gmail.com
 * @description web init
 */
// TODO 初始化任务类

@FlowTask(
    taskName = "initMain",
    dependsOn = TheRouterFlowTask.BEFORE_THEROUTER_INITIALIZATION,//当应用启动后，在TheRouter初始化之前，执行任务
)
fun initMain(context: Context) {
    LogUtils.i("main init")
    initUtils(context)
    initLog(context)
}

private fun initUtils(context: Context) {
    Utils.init(context as Application?)
}

private fun initLog(context: Context) {
    // 线上环境不开启 log。开发时使用
    val config = LogUtils.getConfig()
    config.isLogSwitch = BuildConfig.DEBUG

    // Timber 用于线上 log 埋点
    if (BuildConfig.DEBUG) {
        Timber.plant(Timber.DebugTree())
    } else {
        Timber.plant(CrashReportingTree())
    }
}

@FlowTask(
    taskName = "initWeb",
    dependsOn = TheRouterFlowTask.APP_ONSPLASH,//当应用的首个Activity.onCreate()执行后初始化
)
fun initWeb(context: Context) {
    // 根据手机 CPU 核心数（或者手机内存等条件）设置缓存池容量
    WebViewPool.getInstance().setMaxPoolSize(min(Runtime.getRuntime().availableProcessors(), 3))
    WebViewPool.getInstance().init(context)

    // 加载本地模板用的 WebView 复用池
    TemplateWebViewPool.getInstance()
        .setMaxPoolSize(min(Runtime.getRuntime().availableProcessors(), 3))
    TemplateWebViewPool.getInstance().init(context)
}

const val PRIVACY_POLICY_TEST_INIT = "PrivacyPolicyTestInit"

/**
 * 同意隐私协议后初始化
 */
@FlowTask(taskName = "initTest", dependsOn = PRIVACY_POLICY_TEST_INIT)
fun initTest(context: Context) {
    LogUtils.i("init test")
    ToastUtils.showShort(R.string.privacy_policy_test)
}

