package com.example.messenger.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
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

@Composable
fun SettingsScreen(navController: NavController) {
    val settingsItems = listOf(
        SettingsItem("Аккаунт", Icons.Default.Person),
        SettingsItem("Уведомления", Icons.Default.Notifications),
        SettingsItem("Безопасность", Icons.Default.Security),
        SettingsItem("Тема", Icons.Default.Palette),
        SettingsItem("О приложении", Icons.Default.Info)
    )

    Scaffold(
        containerColor = Color(0xFFBDBDBD), // серый фон как в ChatList
        bottomBar = { BottomBar(navController, "settings") }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 25.dp)
                .fillMaxSize()
        ) {
            // Верхняя панель (как в ChatList)
            Box(
                modifier = Modifier
                    .border(
                        width = 3.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(35.dp)
                    )
                    .clip(RoundedCornerShape(35.dp))                    .background(Color(0xFFFFC107))
                    .padding(top = 15.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(35.dp))
                        .background(Color.White)
                        .padding(horizontal = 24.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.weight(1f)
                            .padding(start = 24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Setting",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }

                    // Чёрный кружок (статус/аватар как на макете)
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color.Black)
                    )
                }
            }

            // Список настроек
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(settingsItems) { item ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(18.dp))
                            .background(Color(0xFFAFAFAF))
                            .clickable { /* TODO: навигация */ }
                            .padding(14.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            // Иконка в кружке
                            Box(
                                modifier = Modifier
                                    .size(42.dp)
                                    .clip(CircleShape)
                                    .background(Color.Black),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(24.dp)
                                )
                            }

                            Text(
                                text = item.title,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}

data class SettingsItem(
    val title: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)