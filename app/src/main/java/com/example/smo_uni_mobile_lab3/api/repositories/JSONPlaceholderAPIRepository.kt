package com.example.smo_uni_mobile_lab3.api.repositories

import android.util.Log
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
                response.body().also {
                    Log.d("PostsRequest", "Posts: $it")
                }
            } else {
                null // Handle errors appropriately
            }
        }
    }

    suspend fun fetchUsers(): List<UserDTO>? {
        return withContext(Dispatchers.IO) {
            val response = apiService.getUsers()
            if (response.isSuccessful) {
                response.body()
            } else {
                null // Handle errors appropriately
            }
        }
    }
}