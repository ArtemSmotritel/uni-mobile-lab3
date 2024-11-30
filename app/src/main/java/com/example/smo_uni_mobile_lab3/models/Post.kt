package com.example.smo_uni_mobile_lab3.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(
    tableName = "post",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("user_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class Post(
    @PrimaryKey(autoGenerate = true) var id: Long,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "content") var content: String,
    @ColumnInfo(name = "image_url") var imageUrl: String,
    @ColumnInfo(name = "user_id", ) var userId: Long,
) : IListItem {
    @Ignore
    override fun id(): String {
        return id.toString()
//        return "ID: [$id] - Author: $userId"
    }

    @Ignore
    override fun title(): String {
        return title
    }

    @Ignore
    override fun description(): String {
        return content
    }

    @Ignore
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
