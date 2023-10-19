package com.ajouunia.core.data.local

import kotlinx.coroutines.flow.Flow

interface DataStoreDataSource {
    fun fetchIdToken(): Flow<Long>
    suspend fun saveIdToken(token: Long)
    suspend fun clearIdToken()
}