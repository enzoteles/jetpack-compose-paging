package com.example.jetpack_compose_paging3.api

import com.example.jetpack_compose_paging3.remote.UsersDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUserList(@Query("page") page: Int): UsersDto
}