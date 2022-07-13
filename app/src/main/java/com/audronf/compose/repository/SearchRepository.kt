package com.audronf.compose.repository

import com.audronf.compose.network.ApiClient
import com.audronf.compose.network.service.SearchApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchRepository {

    private val service = ApiClient.create(SearchApi::class.java)

    suspend fun getSearchScreen() = withContext(Dispatchers.IO) {
        service.getSearchScreen()
    }
}
