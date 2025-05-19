package com.fetch.ApiListApp.presentation.fetch_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fetch.ApiListApp.common.Resources
import com.fetch.ApiListApp.data.FetchListItem
import com.fetch.ApiListApp.domain.use_case.GetItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FetchListViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase
):ViewModel() {

    private val _state = MutableStateFlow<Resources<List<FetchListItem>>>(Resources.Loading())
    val state: StateFlow<Resources<List<FetchListItem>>> = _state

    init {
        getItems()
    }

    private fun getItems(){
        viewModelScope.launch {
            getItemsUseCase().collect{
                _state.value = it
            }
        }
    }
}