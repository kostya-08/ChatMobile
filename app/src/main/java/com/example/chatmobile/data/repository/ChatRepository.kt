package com.example.chatmobile.data.repository

import android.content.Context
import com.example.chatmobile.data.local.database.DatabaseProvider
import com.example.chatmobile.data.local.entity.ChatEntity
import com.example.chatmobile.data.local.entity.MessageEntity
import kotlinx.coroutines.flow.Flow

class ChatRepository(context: Context) {

    private val database = DatabaseProvider.getDatabase(context)
    private val chatDao = database.chatDao()
    private val messageDao = database.messageDao()

    // Получить все чаты
    fun getAllChats(): Flow<List<ChatEntity>> = chatDao.getAllChats()

    // Добавить новый чат
    suspend fun addNewChat(name: String) {
        val chat = ChatEntity(
            name = name,
            lastMessage = "Новый контакт"
        )
        chatDao.insertChat(chat)
    }

    // Получить чат по ID
    suspend fun getChatById(id: String): ChatEntity? = chatDao.getChatById(id)

    // Добавить сообщение
    suspend fun insertMessage(message: MessageEntity) {
        messageDao.insertMessage(message)
    }

    // Получить сообщения чата
    fun getMessagesForChat(chatId: String): Flow<List<MessageEntity>> =
        messageDao.getMessagesForChat(chatId)
}