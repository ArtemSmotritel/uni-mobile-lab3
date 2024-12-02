package com.example.smo_uni_mobile_lab3.api.dto

data class PostDTO(
    val id: Long,
    val title: String,
    val body: String,
    val userId: Long,
)
