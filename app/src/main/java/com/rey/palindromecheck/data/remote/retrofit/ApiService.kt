package com.rey.palindromecheck.data.remote.retrofit

import com.rey.palindromecheck.data.remote.retrofit.response.DataItem
import com.rey.palindromecheck.data.remote.retrofit.response.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ):Response
}