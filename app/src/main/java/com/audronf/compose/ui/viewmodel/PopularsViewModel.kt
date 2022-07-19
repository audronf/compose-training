package com.audronf.compose.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.audronf.compose.model.PopularsScreen
import com.audronf.compose.repository.PopularsRepository
import kotlinx.coroutines.launch

class PopularsViewModel : ViewModel() {

    private var repository = PopularsRepository()

    private val _populars: MutableLiveData<PopularsScreen> = MutableLiveData()
    val populars: LiveData<PopularsScreen>
        get() = _populars

    fun getPopularMovies() {
        viewModelScope.launch {
            val response = repository.getPopularMovies()
            if (response.isSuccessful) {
                _populars.postValue(response.body())
            } else {
                _populars.postValue(null)
                // TODO: Error handling
            }
        }
    }
}
