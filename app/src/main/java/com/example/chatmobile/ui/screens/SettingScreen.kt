package com.example.messenger.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.messenger.ui.components.BottomBar

@Composable
fun SettingsScreen(navController: NavController) {

    val settings = listOf(
        "Аккаунт",
        "Уведомления",
        "Безопасность",
        "Тема",
        "О приложении"
    )

    Scaffold(
        bottomBar = {
            BottomBar(navController, "settings")
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            items(settings) { item ->

                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {

                    Text(
                        text = item,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}