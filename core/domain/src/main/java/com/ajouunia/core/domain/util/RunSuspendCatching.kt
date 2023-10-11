package com.ajouunia.core.domain.util

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.coroutines.cancellation.CancellationException
import kotlin.contracts.ExperimentalContracts

@OptIn(ExperimentalContracts::class)
internal inline fun <T> runSuspendCatching(block: () -> T): Result<T> {
    contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
    return runCatching(block).also { result ->
        val exception = result.exceptionOrNull()
        if (exception is CancellationException) throw exception
    }
}