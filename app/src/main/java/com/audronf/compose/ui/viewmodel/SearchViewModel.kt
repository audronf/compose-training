package com.audronf.compose.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.audronf.compose.model.SearchScreen
import com.audronf.compose.repository.SearchRepository
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val repository = SearchRepository()

    private val _searchScreen: MutableLiveData<SearchScreen> = MutableLiveData()
    val searchScreen: LiveData<SearchScreen>
        get() = _searchScreen

    fun retrieveData() {
        viewModelScope.launch {
            val response = repository.getSearchScreen()
            if (response.isSuccessful) {
                _searchScreen.postValue(response.body()!!)
            } else {
                _searchScreen.postValue(null)
                // TODO: Error handling
            }
        }
    }
}
