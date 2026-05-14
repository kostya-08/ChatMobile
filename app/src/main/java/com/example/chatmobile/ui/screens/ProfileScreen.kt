package com.example.chatmobile.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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

@Composable
fun ProfileScreen(navController: NavController) {

    Scaffold(

        containerColor = Color(0xFFBDBDBD),

        bottomBar = {
            BottomBar(navController, "profile")
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            // Верхняя панель
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFFC107))
                    .padding(
                        top = 12.dp,
                        start = 12.dp,
                        end = 12.dp,
                        bottom = 10.dp
                    )
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(22.dp))
                        .background(Color.White)
                        .padding(vertical = 10.dp),

                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "Profile",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }

            // Контент профиля
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 18.dp),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(24.dp))

                // Аватар
                Box(
                    modifier = Modifier
                        .size(110.dp)
                        .clip(CircleShape)
                        .background(Color.Black),

                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(50.dp)
                    )
                }

                Spacer(modifier = Modifier.height(28.dp))

                // Основная карточка
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(24.dp))
                        .background(Color(0xFFAFAFAF))
                        .padding(
                            horizontal = 18.dp,
                            vertical = 20.dp
                        )
                ) {

                    Column {

                        // Имя
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.75f)
                                .height(22.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFFD9D9D9))
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        // Статус
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(18.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFFD9D9D9))
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.85f)
                                .height(18.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFFD9D9D9))
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        // Большой блок информации
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(220.dp)
                                .clip(RoundedCornerShape(22.dp))
                                .background(Color(0xFFD9D9D9))
                        )
                    }
                }
            }
        }
    }
}