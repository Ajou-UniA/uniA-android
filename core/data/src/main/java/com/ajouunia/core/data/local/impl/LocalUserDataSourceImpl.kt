package com.ajouunia.core.data.local.impl

import com.ajouunia.core.data.local.DataStoreDataSource
import com.ajouunia.core.data.local.LocalUserDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalUserDataSourceImpl
@Inject
constructor(
    private val dataStoreDataSource: DataStoreDataSource
) : LocalUserDataSource {
    override fun fetchIdToken(): Flow<Long> = dataStoreDataSource.fetchIdToken()

    override suspend fun saveIdToken(idToken: Long) {
        dataStoreDataSource.saveIdToken(token = idToken)
    }

    override suspend fun clearIdToken() {
        dataStoreDataSource.clearIdToken()
    }

}