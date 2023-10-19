package com.ajouunia.core.data.local.impl

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import com.ajouunia.core.data.local.DataStoreDataSource
import com.ajouunia.core.data.local.datastore
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
    }

    override fun fetchIdToken(): Flow<Long> = context.fetchLongPreference(key = ID_TOKEN)


    override suspend fun saveIdToken(token: Long) {
        context.datastore.edit { preference ->
            preference[ID_TOKEN] = token
        }
    }

    override suspend fun clearIdToken() {
        context.datastore.edit { preference ->
            preference.remove(ID_TOKEN)
        }
    }

}