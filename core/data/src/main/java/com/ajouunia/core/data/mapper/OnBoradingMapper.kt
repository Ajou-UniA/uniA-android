package com.ajouunia.core.data.mapper

import com.ajouunia.core.data.model.response.CheckEmailResponse
import com.ajouunia.core.domain.entity.BaseConditionEntity

// The email is available
// The email already exists
internal fun CheckEmailResponse.toEntity(): BaseConditionEntity = BaseConditionEntity(result = answer.contains("available"))