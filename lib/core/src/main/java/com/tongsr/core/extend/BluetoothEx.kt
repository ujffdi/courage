package com.tongsr.core.extend

import android.Manifest.permission.BLUETOOTH
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import androidx.annotation.RequiresPermission
import com.blankj.utilcode.util.Utils

/*

BluetoothAdapter.getDefaultAdapter() 表示废弃

推荐使用：
val bluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
bluetoothManager.getAdapter()

PS：记得申请权限
 */
//@get:RequiresPermission(BLUETOOTH)
//inline val isBluetoothEnabled: Boolean
//  get() = BluetoothAdapter.getDefaultAdapter()?.isEnabled == true

@get:RequiresPermission(BLUETOOTH)
inline val isBluetoothEnabled: Boolean
  get() = (Utils.getApp().getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager).adapter.isEnabled

