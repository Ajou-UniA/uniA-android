package com.ajouunia.feature.onboarding.utils

import com.ajouunia.feature.onboarding.ConfirmEmailViewModel

internal fun String.isAjouUnivEmail(): Boolean = this.contains(ConfirmEmailViewModel.AJOU_UNIV_DEFAULT_EMAIL_FORM)

internal fun String.isEmptyId(): Boolean = this.split(ConfirmEmailViewModel.AJOU_UNIV_DEFAULT_EMAIL_FORM).let { list ->
    return@let when (list.size) {
        2 -> list[0].isNotEmpty() && list[1].isEmpty()
        else -> false
    }
}