package com.ajouunia.feature.mypage.vm

import androidx.lifecycle.ViewModel
import com.ajouunia.feature.mypage.model.MyPageUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel
@Inject
constructor(

) : ViewModel() {
    private val _uiState = MutableStateFlow<MyPageUIState>(MyPageUIState.Init)
    val uiState: StateFlow<MyPageUIState>
        get() = _uiState


}