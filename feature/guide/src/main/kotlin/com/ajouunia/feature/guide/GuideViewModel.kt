package com.ajouunia.feature.guide

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajouunia.feature.guide.state.GuideUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GuideViewModel
@Inject
constructor(

) : ViewModel() {
    private val _uiState = MutableLiveData<GuideUIState>(GuideUIState.Init)
    val uiState: LiveData<GuideUIState>
        get() = _uiState


}