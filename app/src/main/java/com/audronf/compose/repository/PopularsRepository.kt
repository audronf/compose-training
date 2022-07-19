package com.audronf.compose.repository

import com.audronf.compose.network.ApiClient
import com.audronf.compose.network.service.PopularsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PopularsRepository {

    private val service = ApiClient.create(PopularsApi::class.java)

    suspend fun getPopularMovies() = withContext(Dispatchers.IO) {
        service.getPopularMovies()
    }
}
