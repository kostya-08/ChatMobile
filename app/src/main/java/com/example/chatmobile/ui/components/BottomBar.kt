package com.example.messenger.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomBar(
    navController: NavController,
    selected: String
) {

    NavigationBar {

        NavigationBarItem(
            selected = selected == "profile",
            onClick = {
                navController.navigate("profile")
            },
            icon = {
                Icon(Icons.Default.Person, null)
            }
        )

        NavigationBarItem(
            selected = selected == "chats",
            onClick = {
                navController.navigate("chats")
            },
            icon = {
                Icon(Icons.Default.Chat, null)
            }
        )

        NavigationBarItem(
            selected = selected == "settings",
            onClick = {
                navController.navigate("settings")
            },
            icon = {
                Icon(Icons.Default.Settings, null)
            }
        )
    }
}