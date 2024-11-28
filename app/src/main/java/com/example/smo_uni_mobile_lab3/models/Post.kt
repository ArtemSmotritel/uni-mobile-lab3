package com.example.smo_uni_mobile_lab3.models

data class Post(
    var id: Long,
    var title: String,
    var content: String,
    var imageUrl: String,
    var userId: Long,
) : IListItem {
    override fun title(): String {
        return title
    }

    override fun description(): String {
        return content
    }

    override fun imageUrl(): String {
        return imageUrl
    }
}

class PostBuilder {
    private var id: Long = 0
    private var title: String = ""
    private var content: String = ""
    private var imageUrl: String = ""
    private var userId: Long = 0

    fun id(id: Long) = apply { this.id = id }
    fun title(title: String) = apply { this.title = title }
    fun content(content: String) = apply { this.content = content }
    fun imageUrl(imageUrl: String) = apply { this.imageUrl = imageUrl }
    fun userId(userId: Long) = apply { this.userId = userId }

    fun build(): Post {
        return Post(
            id = id,
            title = title,
            content = content,
            imageUrl = imageUrl,
            userId = userId
        )
    }
}
