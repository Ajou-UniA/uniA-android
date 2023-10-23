package com.ajouunia.core.data.local

import kotlinx.coroutines.flow.Flow

interface LocalUserDataSource {
    fun fetchIdToken(): Flow<Long>
    fun fetchRememberToken(): Flow<Boolean>

    suspend fun saveIdToken(idToken: Long)
    suspend fun saveRememberToken(token: Boolean)

    suspend fun clearIdToken()
    suspend fun clearRememberToken()
    suspend fun clearAll()

}