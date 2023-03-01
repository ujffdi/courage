package com.tongsr.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/12/7
 * @email ujffdtfivkg@gmail.com
 * @description DataStore 扩展
 */

/*

请勿在同一进程中为给定文件创建多个 DataStore 实例，否则会破坏所有 DataStore 功能。如果给定文件在同一进程中有多个有效的 DataStore，DataStore 在读取或更新数据时将抛出 IllegalStateException。

DataStore 的通用类型必须不可变。更改 DataStore 中使用的类型会导致 DataStore 提供的所有保证失效，并且可能会造成严重的、难以发现的 bug。强烈建议您使用可保证不可变性、具有简单的 API 且能够高效进行序列化的协议缓冲区。

切勿在同一个文件中混用 SingleProcessDataStore 和 MultiProcessDataStore。如果您打算从多个进程访问 DataStore，请始终使用 MultiProcessDataStore。

 */
// At the top level of your kotlin file:
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "courage")

// 使用教程
// https://developer.android.com/topic/libraries/architecture/datastore?hl=zh-cn
