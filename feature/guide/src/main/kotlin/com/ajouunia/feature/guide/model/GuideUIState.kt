package com.ajouunia.feature.guide.model

import com.ajouunia.core.domain.entity.GuideEntity

sealed class GuideUIState(
    open val topicIndex: Int = 0,
    open val guideList: List<GuideEntity> = emptyList()
) {

    object Init : GuideUIState()

    data class Loading(
        override val topicIndex: Int,
        override val guideList: List<GuideEntity>
    ) : GuideUIState(
        topicIndex = topicIndex,
        guideList = guideList
    )

    data class UpdateInfo(
        override val topicIndex: Int,
        override val guideList: List<GuideEntity>
    ) : GuideUIState(
        topicIndex = topicIndex,
        guideList = guideList
    )

    data class Error(
        override val topicIndex: Int,
        override val guideList: List<GuideEntity>,
        val exception: Throwable? = null
    ) : GuideUIState(
        topicIndex = topicIndex,
        guideList = guideList
    )

    data class Menu(
        override val topicIndex: Int,
        override val guideList: List<GuideEntity>
    ) : GuideUIState(
        topicIndex = topicIndex,
        guideList = guideList
    )

}