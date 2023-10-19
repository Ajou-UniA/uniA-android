package com.ajouunia.core.data.utils.extensions

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import com.ajouunia.core.data.local.datastore
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.io.IOException

internal suspend fun dataEmptyException(
    exception: Throwable
) = flow {
    if (exception is IOException) {
        emit(emptyPreferences())
    } else {
        throw exception
    }
}

internal fun Context.fetchStringPreference(
    key: Preferences.Key<String>
) = this.datastore.data.catch { exception ->
    dataEmptyException(exception = exception)
}.map { preference -> preference[key] ?: "" }

internal fun Context.fetchLongPreference(
    key: Preferences.Key<Long>
) = this.datastore.data.catch { exception ->
    dataEmptyException(exception = exception)
}.map { preference -> preference[key] ?: -1L }