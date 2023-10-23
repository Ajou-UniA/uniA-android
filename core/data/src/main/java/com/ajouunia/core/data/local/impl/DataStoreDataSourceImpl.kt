package com.ajouunia.core.data.local.impl

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import com.ajouunia.core.data.local.DataStoreDataSource
import com.ajouunia.core.data.local.datastore
import com.ajouunia.core.data.utils.extensions.fetchBooleanPreference
import com.ajouunia.core.data.utils.extensions.fetchLongPreference
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataStoreDataSourceImpl
@Inject
constructor(
    private val context: Context,
) : DataStoreDataSource {
    companion object {
        private val ID_TOKEN = longPreferencesKey("ID_TOKEN")
        private val REMEMBER_TOKEN = booleanPreferencesKey("REMEMBER_TOKEN")
    }

    override fun fetchIdToken(): Flow<Long> = context.fetchLongPreference(key = ID_TOKEN)

    override fun fetchRememberToken(): Flow<Boolean> = context.fetchBooleanPreference(key = REMEMBER_TOKEN)

    override suspend fun saveIdToken(token: Long) {
        context.datastore.edit { preference ->
            preference[ID_TOKEN] = token
        }
    }

    override suspend fun saveRememberToken(token: Boolean) {
        context.datastore.edit { preference ->
            preference[REMEMBER_TOKEN] = token
        }
    }

    override suspend fun clearIdToken() {
        context.datastore.edit { preference ->
            preference.remove(ID_TOKEN)
        }
    }

    override suspend fun clearRememberToken() {
        context.datastore.edit { preference ->
            preference.remove(REMEMBER_TOKEN)
        }
    }

    override suspend fun clearAll() {
        clearIdToken()
        clearRememberToken()
    }

}