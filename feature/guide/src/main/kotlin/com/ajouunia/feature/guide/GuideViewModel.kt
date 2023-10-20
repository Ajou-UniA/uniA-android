package com.ajouunia.feature.guide

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajouunia.core.domain.usecase.GetGuideListUseCase
import com.ajouunia.feature.guide.state.GuideUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GuideViewModel
@Inject
constructor(
    private val getGuideListUseCase: GetGuideListUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<GuideUIState>(GuideUIState.Init)
    val uiState: LiveData<GuideUIState>
        get() = _uiState


    fun getGuideList() {
        val state = _uiState.value

        when (state) {
            null,
            is GuideUIState.Menu,
            is GuideUIState.Loading -> return
            else -> Unit
        }

        _uiState.value = GuideUIState.Loading(
            topicIndex = state.topicIndex,
            guideList = state.guideList
        )

        fetchRemoteGuide(state = state)
    }

    private fun fetchRemoteGuide(state: GuideUIState) = viewModelScope.launch {
        getGuideListUseCase(state.topicIndex + 1).onSuccess {
            _uiState.postValue(
                GuideUIState.UpdateInfo(
                    topicIndex = state.topicIndex,
                    guideList = it
                )
            )
        }.onFailure {
            Log.d("fetchRemoteGuide", it.stackTraceToString())
            _uiState.postValue(
                GuideUIState.Error(
                    topicIndex = state.topicIndex,
                    guideList = state.guideList,
                    exception = it
                )
            )
        }
    }

    fun onClickMenu() {
        val state = _uiState.value

        when (state) {
            null,
            is GuideUIState.Menu,
            is GuideUIState.Loading -> return
            else -> Unit
        }

        _uiState.value = GuideUIState.Menu(
            topicIndex = state.topicIndex,
            guideList = state.guideList
        )
    }

    fun onClickMenuItem(index: Int) {
        val state = _uiState.value ?: return

        when (state) {
            is GuideUIState.Loading -> return
            else -> Unit
        }

        _uiState.value = GuideUIState.Loading(
            topicIndex = index,
            guideList = emptyList()
        )

        fetchRemoteGuide(
            state = GuideUIState.Loading(
                topicIndex = index,
                guideList = emptyList()
            )
        )
    }
}