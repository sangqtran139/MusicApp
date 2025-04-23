package com.sangtq.network.retrofit

import com.sangtq.model.ResponseData
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("endpoint/{id}")
    suspend fun getData(@Path("id") id: String): ResponseData
}