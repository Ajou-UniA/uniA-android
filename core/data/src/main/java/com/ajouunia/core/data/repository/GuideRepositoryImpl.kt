package com.ajouunia.core.data.repository

import com.ajouunia.core.data.remote.GuideDataSource
import com.ajouunia.core.domain.entity.GuideEntity
import com.ajouunia.core.domain.repository.GuideRepository
import javax.inject.Inject

class GuideRepositoryImpl
@Inject
constructor(
    private val guideDataSource: GuideDataSource
) : GuideRepository {

    override suspend fun getGuideList(index: Int): List<GuideEntity>? {
        val titleList = guideDataSource.getGuideTitleListByTopicIndex(index)
        val contentList = guideDataSource.getGuideContentListByTopicIndex(index)

        return if (titleList == null || contentList == null) {
            null
        } else if (titleList.size != contentList.size) {
            emptyList()
        } else {
            val result = mutableListOf<GuideEntity>()

            for (i in titleList.indices) {
                result.add(
                    GuideEntity(
                        index = titleList[i].index,
                        title = titleList[i].topicTitle,
                        content = contentList[i].topicContent
                    )
                )
            }

            result
        }
    }

}