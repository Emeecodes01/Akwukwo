package com.mobigods.remote.services

import com.mobigods.remote.models.ApiResponse
import retrofit2.http.GET

interface AkwukwoContentService {

    @GET("3p/api/content/grade")
    suspend fun fetchContent(): ApiResponse
}