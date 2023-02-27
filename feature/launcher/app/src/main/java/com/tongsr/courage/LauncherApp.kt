package com.tongsr.courage

import android.content.Context
import com.tongsr.core.BaseApplication
import com.tongsr.router.setTheRouterDebug

/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/12/6
 * @email ujffdtfivkg@gmail.com
 * @description LauncherApp
 */
class LauncherApp : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        setTheRouterDebug(BuildConfig.DEBUG)
        super.attachBaseContext(base)
    }

}