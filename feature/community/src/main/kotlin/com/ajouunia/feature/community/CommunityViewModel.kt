package com.ajouunia.feature.community

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajouunia.feature.community.state.CommunityUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel
@Inject
constructor(

) : ViewModel() {
    private val _uiState = MutableLiveData<CommunityUIState>(CommunityUIState.Init)
    val uiState: LiveData<CommunityUIState>
        get() = _uiState


}