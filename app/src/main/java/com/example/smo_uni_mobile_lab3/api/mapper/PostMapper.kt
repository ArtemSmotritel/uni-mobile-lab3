package com.example.smo_uni_mobile_lab3.api.mapper

import com.example.smo_uni_mobile_lab3.api.dto.PostDTO
import com.example.smo_uni_mobile_lab3.models.Post
import com.example.smo_uni_mobile_lab3.models.PostBuilder
import com.example.smo_uni_mobile_lab3.models.User

class PostMapper {
    companion object {
        private val imageUrls: List<String> = listOf("")

        fun map(post: PostDTO, users: List<User>): Post? {
            val authorId = users.find { post.userId == it.apiId }?.id
            if (authorId == null) {
                return null
            }

            return PostBuilder()
                .title(post.title)
                .content(post.body)
                .userId(authorId)
                .imageUrl(imageUrls.random())
                .build()
        }
    }
}
