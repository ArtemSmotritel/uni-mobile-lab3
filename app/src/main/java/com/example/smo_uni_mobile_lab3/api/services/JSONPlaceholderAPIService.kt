package com.example.smo_uni_mobile_lab3.api.services

import com.example.smo_uni_mobile_lab3.api.dto.PostDTO
import com.example.smo_uni_mobile_lab3.api.dto.UserDTO
import retrofit2.Response
import retrofit2.http.GET

interface JSONPlaceholderAPIService {
    @GET("posts")
    suspend fun getPosts(): Response<List<PostDTO>>

    @GET("users")
    suspend fun getUsers(): Response<List<UserDTO>>
}
