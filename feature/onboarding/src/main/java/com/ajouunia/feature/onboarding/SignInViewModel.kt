package com.ajouunia.feature.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajouunia.feature.onboarding.state.SignInUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel
@Inject
constructor(

) : ViewModel() {
    private val _uiState = MutableLiveData<SignInUIState>(SignInUIState.Init)
    val uiState: LiveData<SignInUIState>
        get() = _uiState

}