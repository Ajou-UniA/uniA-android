package com.ajouunia.core.data.mapper

import com.ajouunia.core.data.model.response.IsDuplicateEmailResponse
import com.ajouunia.core.data.model.response.SignInResponse
import com.ajouunia.core.domain.entity.BaseConditionEntity

// The email is available
// The email already exists
internal fun IsDuplicateEmailResponse.toEntity(): BaseConditionEntity = BaseConditionEntity(result = answer.contains("available"))

internal fun SignInResponse.toEntity(): BaseConditionEntity = BaseConditionEntity(
    result = when (result) {
        1 -> true
        else -> false
    }
)