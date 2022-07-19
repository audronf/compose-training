package com.audronf.compose.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.audronf.compose.model.Movie
import com.audronf.compose.repository.DetailsRepository
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {

    private var repository = DetailsRepository()

    private val _details: MutableLiveData<Movie> = MutableLiveData()
    val details: LiveData<Movie>
        get() = _details

    fun getPopularMovies() {
        viewModelScope.launch {
            val response = repository.getDetails()
            if (response.isSuccessful) {
                _details.postValue(response.body())
            } else {
                _details.postValue(null)
                // TODO: Error handling
            }
        }
    }
}
