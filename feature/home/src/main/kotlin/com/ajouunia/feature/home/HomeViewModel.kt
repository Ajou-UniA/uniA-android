package com.ajouunia.feature.home

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


}