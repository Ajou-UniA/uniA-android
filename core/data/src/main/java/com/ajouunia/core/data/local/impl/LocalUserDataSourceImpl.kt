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

    override fun fetchRememberToken(): Flow<Boolean> = dataStoreDataSource.fetchRememberToken()

    override suspend fun saveIdToken(idToken: Long) = dataStoreDataSource.saveIdToken(idToken)

    override suspend fun saveRememberToken(token: Boolean) = dataStoreDataSource.saveRememberToken(token)

    override suspend fun clearIdToken() {
        dataStoreDataSource.clearIdToken()
    }

    override suspend fun clearRememberToken() {
        dataStoreDataSource.clearRememberToken()
    }

    override suspend fun clearAll() {
        dataStoreDataSource.clearAll()
    }

}