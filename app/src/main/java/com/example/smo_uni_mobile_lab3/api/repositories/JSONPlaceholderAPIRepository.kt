package com.example.smo_uni_mobile_lab3.api.repositories

import android.util.Log
import com.example.smo_uni_mobile_lab3.api.dto.PhotoDTO
import com.example.smo_uni_mobile_lab3.api.dto.PostDTO
import com.example.smo_uni_mobile_lab3.api.dto.UserDTO
import com.example.smo_uni_mobile_lab3.api.services.JSONPlaceholderAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class JSONPlaceholderAPIRepository(private val apiService: JSONPlaceholderAPIService) {
    suspend fun fetchPosts(): List<PostDTO>? {
        return withContext(Dispatchers.IO) {
            val response = apiService.getPosts()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }

    suspend fun fetchUsers(): List<UserDTO>? {
        return withContext(Dispatchers.IO) {
            val response = apiService.getUsers()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }

    suspend fun fetchAlbumImages(albumId: Long): List<PhotoDTO>? {
        return withContext(Dispatchers.IO) {
            val response = apiService.getAlbumPhotos(albumId)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }
}