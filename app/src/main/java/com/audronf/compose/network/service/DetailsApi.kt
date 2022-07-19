package com.audronf.compose.network.service

import com.audronf.compose.model.Movie
import retrofit2.Response
import retrofit2.http.GET

interface DetailsApi {

    @GET("/details")
    suspend fun getDetails(): Response<Movie>
}
