package com.audronf.compose.network.service

import com.audronf.compose.model.SearchScreen
import retrofit2.Response
import retrofit2.http.GET

interface SearchApi {

    @GET("/search")
    suspend fun getSearchScreen(): Response<SearchScreen>
}
