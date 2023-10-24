package com.ajouunia.feature.home.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajouunia.feature.home.state.HomeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(

) : ViewModel() {
    private val _uiState = MutableLiveData<HomeUIState>(HomeUIState.Init)
    val uiState: LiveData<HomeUIState>
        get() = _uiState


    fun changeMapState() {
        val state = _uiState.value ?: return

        _uiState.value = HomeUIState.Map(state.taskList)
    }

    fun closeMapState() {
        _uiState.value = HomeUIState.Init
    }

}