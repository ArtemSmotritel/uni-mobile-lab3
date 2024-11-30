package com.example.smo_uni_mobile_lab3.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.smo_uni_mobile_lab3.models.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Query("SELECT * FROM post")
    fun getAllAsFlow(): Flow<List<Post>>

    @Query("SELECT * FROM post")
    fun getAll(): List<Post>

    @Query("SELECT * FROM post WHERE id IN (:postIds)")
    fun loadAllByIds(postIds: IntArray): List<Post>

    @Insert
    fun insertAll(vararg posts: Post)

    @Delete
    fun delete(post: Post)

    @Query("DELETE FROM post")
    fun deleteAll()
}
