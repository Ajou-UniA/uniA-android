package com.ajouunia.feature.community.vm

import androidx.lifecycle.ViewModel
import com.ajouunia.feature.community.model.CommunityUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel
@Inject
constructor(

) : ViewModel() {
    private val _uiState = MutableStateFlow<CommunityUIState>(CommunityUIState.Init)
    val uiState: StateFlow<CommunityUIState>
        get() = _uiState


}