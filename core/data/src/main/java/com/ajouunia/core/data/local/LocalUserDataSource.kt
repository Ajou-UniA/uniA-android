package com.ajouunia.core.data.local

import kotlinx.coroutines.flow.Flow

interface LocalUserDataSource {
    fun fetchIdToken(): Flow<Long>
    suspend fun saveIdToken(idToken: Long)
    suspend fun clearIdToken()
}