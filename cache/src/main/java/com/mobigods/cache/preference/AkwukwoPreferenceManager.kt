package com.mobigods.cache.preference

import android.content.Context
import android.content.SharedPreferences
import com.mobigods.cache.utils.CacheConstants
import com.mobigods.core.utils.edit
import javax.inject.Inject

class AkwukwoPreferenceManager @Inject constructor(private val context: Context): IPreferenceManager {

    private val sharedPreference: SharedPreferences by lazy {
        context.getSharedPreferences(CacheConstants.preferenceName, Context.MODE_PRIVATE)
    }

    override var lastSynced: Long
        get() = sharedPreference.getLong(LAST_SYNCED, 0)
        set(value) {sharedPreference.edit { putLong(LAST_SYNCED, value) } }


    companion object {
        const val LAST_SYNCED = "last-synced"
    }
}