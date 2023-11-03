package com.ajouunia.feature.home.vm

import android.content.res.AssetManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajouunia.core.domain.entity.AjouMapGuideEntity
import com.ajouunia.core.domain.entity.AjouMapGuideListEntity
import com.ajouunia.feature.home.model.HomeUIState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(

) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUIState>(HomeUIState.Init)
    val uiState: StateFlow<HomeUIState>
        get() = _uiState


    fun changeMapState() {
        val state = _uiState.value

        _uiState.value = HomeUIState.Map(
            state.taskList,
            state.partitions
        )
    }

    fun closeMapState() {
        val state = _uiState.value

        _uiState.value = HomeUIState.UpdateInfo(
            state.taskList,
            state.partitions
        )
    }

    fun fetchMapGuide(assetManager: AssetManager) = viewModelScope.launch {
        val result: List<List<AjouMapGuideEntity>> = kotlin.runCatching {
            val inputStream = assetManager.open("ajou_univ_map_guide.json")
            val reader = inputStream.bufferedReader()
            val gson = Gson()
            gson.fromJson(reader, AjouMapGuideListEntity::class.java).mapGuide.chunked(10)
        }.getOrNull() ?: emptyList()

        _uiState.emit(
            HomeUIState.UpdateInfo(
                taskList = _uiState.value.taskList,
                partitions = result
            )
        )
    }

}