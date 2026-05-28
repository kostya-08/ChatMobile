package com.example.chatmobile.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class MessageEntity(
    @PrimaryKey val id: String = java.util.UUID.randomUUID().toString(),
    val chatId: String,
    val text: String,
    val isMine: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)