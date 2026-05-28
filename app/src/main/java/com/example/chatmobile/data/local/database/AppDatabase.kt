package com.example.chatmobile.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.chatmobile.data.local.dao.ChatDao
import com.example.chatmobile.data.local.dao.MessageDao
import com.example.chatmobile.data.local.entity.ChatEntity
import com.example.chatmobile.data.local.entity.MessageEntity

@Database(
    entities = [ChatEntity::class, MessageEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun chatDao(): ChatDao
    abstract fun messageDao(): MessageDao
}