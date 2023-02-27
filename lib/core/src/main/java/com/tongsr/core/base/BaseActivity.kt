package com.tongsr.core.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity


/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/11/13
 * @email ujffdtfivkg@gmail.com
 * @description 基类 Activity
 */
abstract class BaseActivity : AppCompatActivity(), IBaseView {

    protected lateinit var mContext: Context

    protected lateinit var mActivity: Activity

    protected lateinit var mContentView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        mActivity = this
        initData(intent.extras)
        setContentView()
        initView(savedInstanceState, mContentView)
        doBusiness()
    }

    override fun setContentView() {
        if (onBindLayout() <= 0) {
            return
        }
        mContentView = LayoutInflater.from(this).inflate(onBindLayout(), null)
        setContentView(mContentView)
    }

}