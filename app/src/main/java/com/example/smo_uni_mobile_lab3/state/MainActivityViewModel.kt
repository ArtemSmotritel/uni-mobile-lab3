package com.example.smo_uni_mobile_lab3.state

import androidx.lifecycle.ViewModel
import com.example.smo_uni_mobile_lab3.models.IListItem
import com.example.smo_uni_mobile_lab3.models.tripleFakeData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MainActivityState(
    val list: List<IListItem> = tripleFakeData(),
)

class MainActivityViewModel : ViewModel() {

    private val _state = MutableStateFlow(MainActivityState())
    val state: StateFlow<MainActivityState> = _state.asStateFlow()

}
