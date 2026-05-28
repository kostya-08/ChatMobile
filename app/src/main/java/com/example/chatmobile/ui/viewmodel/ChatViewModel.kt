package com.example.chatmobile.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatmobile.data.local.entity.MessageEntity
import com.example.chatmobile.data.repository.ChatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ChatViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ChatRepository(application.applicationContext)

    fun getMessages(chatId: String): Flow<List<MessageEntity>> {
        return repository.getMessagesForChat(chatId)
    }

    fun sendMessage(chatId: String, text: String, isMine: Boolean = true) {
        viewModelScope.launch {
            val message = MessageEntity(
                chatId = chatId,
                text = text,
                isMine = isMine
            )
            repository.insertMessage(message)
        }
    }
}