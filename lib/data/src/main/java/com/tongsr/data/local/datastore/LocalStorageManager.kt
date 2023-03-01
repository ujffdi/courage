package com.tongsr.data.local.datastore

import android.app.Application
import androidx.annotation.NonNull
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/28
 * @email ujffdtfivkg@gmail.com
 * @description LocalStorageManager
 */
object LocalStorageManager {

    private lateinit var dataStore: DataStore<Preferences>

    /**
     * 初始化
     * @param context context
     */
    fun init(context: Application) {
        if (this::dataStore.isInitialized) {
            return
        }
        dataStore = context.dataStore
    }

    suspend fun <T> put(key: Preferences.Key<T>, value: T) {
        dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    suspend fun <T> put(vararg pairs: Pair<Preferences.Key<T>, T>) {
        when (pairs.size) {
            1 -> {
                val pair = pairs[0]
                put(pair.first, pair.second)
            }
            else -> {
                dataStore.edit { preferences ->
                    for ((key, value) in pairs) {
                        preferences[key] = value
                    }
                }
            }
        }
    }

    @NonNull
    fun getString(key: Preferences.Key<String>): Flow<String> = getInternal(key, "")

    @NonNull
    fun getInt(key: Preferences.Key<Int>): Flow<Int> = get(key, 0)

    @NonNull
    fun getBoolean(key: Preferences.Key<Boolean>): Flow<Boolean> = getInternal(key, false)

    @NonNull
    fun getLong(key: Preferences.Key<Long>): Flow<Long> = getInternal(key, 0)

    @NonNull
    fun getFloat(key: Preferences.Key<Float>): Flow<Float> = getInternal(key, 0F)

    @NonNull
    fun getDouble(key: Preferences.Key<Double>): Flow<Double> = getInternal(key, 0.00)

    @NonNull
    fun getStringSet(key: Preferences.Key<Set<String>>): Flow<Set<String>> = getInternal(key, emptySet())

    fun <T> get(key: Preferences.Key<T>, defaultValue: T): Flow<T> =
        dataStore.data.map { preferences ->
            preferences[key] ?: defaultValue
        }

    private inline fun <reified T> getInternal(key: Preferences.Key<T>, defaultValue: T): Flow<T> =
        dataStore.data.map { preferences ->
            preferences[key] ?: defaultValue
        }

    suspend fun <T> remove(key: Preferences.Key<T>) {
        withContext(Dispatchers.IO) {
            dataStore.edit { settings ->
                settings.remove(key)
            }
        }
    }

    suspend fun clear() {
        withContext(Dispatchers.IO) {
            dataStore.edit { settings ->
                settings.clear()
            }
        }
    }

}

