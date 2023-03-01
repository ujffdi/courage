package com.tongsr.wanapp.export.repository

import androidx.datastore.preferences.core.booleanPreferencesKey
import com.tongsr.core.base.BaseRepository
import com.tongsr.data.local.datastore.LocalStorageManager
import kotlinx.coroutines.flow.Flow

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/27
 * @email ujffdtfivkg@gmail.com
 * @description 隐私协议Repository
 */

/**
 * 是否显示隐私协议
 */
class PrivacyPolicyRepository : BaseRepository() {

    private val privacyPolicyKeyPreferences = booleanPreferencesKey("PrivacyPolicyShow")

    val state: Flow<Boolean>
        get() = LocalStorageManager.getBoolean(privacyPolicyKeyPreferences)

    suspend fun saveState() {
        LocalStorageManager.put(privacyPolicyKeyPreferences, true)
    }

}