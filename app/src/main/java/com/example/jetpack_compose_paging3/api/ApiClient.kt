package com.example.jetpack_compose_paging3.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private fun getLoggingInterceptor() = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BASIC)
    private fun getHttpClient() = OkHttpClient.Builder()
        .addInterceptor(getLoggingInterceptor())
        .build()

    private fun getClient(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .client(getHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService: ApiService = getClient().create(ApiService::class.java)
}