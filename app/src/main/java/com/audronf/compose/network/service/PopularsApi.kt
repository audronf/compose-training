package com.audronf.compose.network.service

import com.audronf.compose.model.MoviePreview
import com.audronf.compose.model.PopularsScreen
import retrofit2.Response
import retrofit2.http.GET

interface PopularsApi {

    @GET("/populars")
    suspend fun getPopularMovies(): Response<PopularsScreen>
}
