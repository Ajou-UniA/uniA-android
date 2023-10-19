package com.ajouunia.core.domain.usecase

import com.ajouunia.core.domain.entity.GuideEntity
import com.ajouunia.core.domain.repository.GuideRepository
import com.ajouunia.core.domain.util.runSuspendCatching
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetGuideListUseCase
@Inject
constructor(
    private val repository: GuideRepository
) {

    suspend operator fun invoke(index: Int): Result<List<GuideEntity>> = runSuspendCatching {
        repository.getGuideList(index = index) ?: throw NullPointerException()
    }

}