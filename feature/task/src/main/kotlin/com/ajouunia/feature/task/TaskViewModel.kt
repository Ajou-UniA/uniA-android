package com.ajouunia.feature.task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajouunia.feature.task.state.TaskUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskViewModel
@Inject
constructor(

) : ViewModel() {
    private val _uiState = MutableLiveData<TaskUIState>(TaskUIState.Init)
    val uiState: LiveData<TaskUIState>
        get() = _uiState


}