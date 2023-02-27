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

// At the top level of your kotlin file:
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "courage")

// 使用教程
// https://developer.android.com/topic/libraries/architecture/datastore?hl=zh-cn