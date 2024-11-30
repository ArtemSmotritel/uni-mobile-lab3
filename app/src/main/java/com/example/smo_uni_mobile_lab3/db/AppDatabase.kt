package com.example.smo_uni_mobile_lab3.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.smo_uni_mobile_lab3.db.dao.PostDao
import com.example.smo_uni_mobile_lab3.db.dao.UserDao
import com.example.smo_uni_mobile_lab3.models.Post
import com.example.smo_uni_mobile_lab3.models.User

@Database(entities = [User::class, Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun postDao(): PostDao

    companion object {
        private var Instance: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context, klass = AppDatabase::class.java, name = "app-database-name"
                ).build().also { Instance = it }
            }
        }
    }
}
