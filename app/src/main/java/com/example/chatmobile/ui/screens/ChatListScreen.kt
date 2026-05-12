package com.example.messenger.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.messenger.model.Chat
import com.example.messenger.ui.components.BottomBar

@Composable
fun ChatListScreen(navController: NavController) {

    val chats = listOf(
        Chat("Alex", "Привет"),
        Chat("Maria", "Как дела?"),
        Chat("John", "Увидимся завтра"),
        Chat("Kate", "Ок")
    )

    Scaffold(

        bottomBar = {
            BottomBar(navController, "chats")
        },

        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Default.Add, null)
            }
        }

    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            items(chats) { chat ->

                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("chat/${chat.name}")
                        }
                ) {

                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Column {

                            Text(
                                text = chat.name,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Text(
                                text = chat.lastMessage
                            )
                        }
                    }
                }
            }
        }
    }
}