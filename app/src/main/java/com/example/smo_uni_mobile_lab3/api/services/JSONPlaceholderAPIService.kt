package com.example.smo_uni_mobile_lab3.api.services

import com.example.smo_uni_mobile_lab3.api.dto.PhotoDTO
import com.example.smo_uni_mobile_lab3.api.dto.PostDTO
import com.example.smo_uni_mobile_lab3.api.dto.UserDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface JSONPlaceholderAPIService {
    @GET("posts")
    suspend fun getPosts(): Response<List<PostDTO>>

    @GET("users")
    suspend fun getUsers(): Response<List<UserDTO>>

    @GET("albums/{id}/photos")
    suspend fun getAlbumPhotos(@Path("id") albumId: Long): Response<List<PhotoDTO>>
}
