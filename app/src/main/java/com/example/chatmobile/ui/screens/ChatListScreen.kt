package com.example.chatmobile.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chatmobile.ui.components.BottomBar
import com.example.messenger.model.Chat

@Composable
fun ChatListScreen(navController: NavController) {

    val chats = listOf(
        Chat("Alex", "Привет"),
        Chat("Maria", "Как дела?"),
        Chat("John", "Увидимся завтра"),
        Chat("Kate", "Ок")
    )

    Scaffold(

        containerColor = Color(0xFFBDBDBD),

        bottomBar = {
            BottomBar(navController, "chats")
        },

        floatingActionButton = {

            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
                    .clickable {

                    },

                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 25.dp)
                .fillMaxSize()
        ) {

            // Верхняя панель
            Box(
                modifier = Modifier
                    .border(
                        width = 3.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(35.dp)
                    )
                    .clip(RoundedCornerShape(35.dp))
                    .background(Color(0xFFFFC107))
                    .padding(top = 15.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)

            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(35.dp))
                        .background(Color.White)
                        .padding(
                            horizontal = 24.dp,
                            vertical = 10.dp
                        ),

                    verticalAlignment = Alignment.CenterVertically

                ) {

                    // Заголовок
                    Box(
                        modifier = Modifier.weight(1f)
                            .padding(start = 24.dp),
                    contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = "Chat",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }

                    // Аватар
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color.Black)
                    )
                }
            }

            // Список чатов
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp)
            ) {

                items(chats) { chat ->

                    Box(
                        modifier = Modifier
                            .padding(vertical = 6.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(35.dp))
                            .background(Color(0xFFAFAFAF))
                            .clickable {
                                navController.navigate("chat/${chat.name}")
                            }
                            .padding(12.dp)
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(42.dp)
                                    .clip(CircleShape)
                                    .background(Color.Black),

                                contentAlignment = Alignment.Center
                            ) {

                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(22.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column {

                                Text(
                                    text = chat.name,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp,
                                    color = Color.Black
                                )

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = chat.lastMessage,
                                    fontSize = 13.sp,
                                    color = Color.DarkGray
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}