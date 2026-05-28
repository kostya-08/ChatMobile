package com.example.chatmobile.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatmobile.data.repository.ChatRepository
import com.example.chatmobile.data.local.entity.ChatEntity
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ChatListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ChatRepository(application.applicationContext)

    val chats: StateFlow<List<ChatEntity>> = repository.getAllChats()
        .stateIn(
            scope = viewModelScope,
            started = kotlinx.coroutines.flow.SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addNewChat(name: String) {
        viewModelScope.launch {
            repository.addNewChat(name)
        }
    }
}