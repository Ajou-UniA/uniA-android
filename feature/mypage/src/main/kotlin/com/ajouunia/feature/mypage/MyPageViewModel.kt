package com.ajouunia.feature.mypage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajouunia.feature.mypage.state.MyPageUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel
@Inject
constructor(

) : ViewModel() {
    private val _uiState = MutableLiveData<MyPageUIState>(MyPageUIState.Init)
    val uiState: LiveData<MyPageUIState>
        get() = _uiState


}