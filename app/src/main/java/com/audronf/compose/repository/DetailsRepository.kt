package com.audronf.compose.repository

import com.audronf.compose.network.ApiClient
import com.audronf.compose.network.service.DetailsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetailsRepository {

    private val service = ApiClient.create(DetailsApi::class.java)

    suspend fun getDetails() = withContext(Dispatchers.IO) {
        service.getDetails()
    }
}
