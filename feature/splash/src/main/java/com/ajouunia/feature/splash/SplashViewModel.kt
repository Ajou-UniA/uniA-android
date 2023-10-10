package com.ajouunia.feature.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajouunia.feature.splash.state.SplashUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel
@Inject
constructor(

) : ViewModel() {
    private val _uiState = MutableLiveData<SplashUIState>(SplashUIState.Init)
    val uiState: LiveData<SplashUIState>
        get() = _uiState

    init {
        viewModelScope.launch {
            delay(500)
            loadAutoLogin()
        }
    }

    private fun loadAutoLogin() = viewModelScope.launch {
        delay(2000)
        _uiState.postValue(SplashUIState.OnBoarding)
    }

}