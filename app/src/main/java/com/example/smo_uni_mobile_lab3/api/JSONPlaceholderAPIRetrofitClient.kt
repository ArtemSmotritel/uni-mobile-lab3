package com.example.smo_uni_mobile_lab3.api

import com.example.smo_uni_mobile_lab3.api.services.JSONPlaceholderAPIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JSONPlaceholderAPIRetrofitClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val apiService: JSONPlaceholderAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JSONPlaceholderAPIService::class.java)
    }
}
