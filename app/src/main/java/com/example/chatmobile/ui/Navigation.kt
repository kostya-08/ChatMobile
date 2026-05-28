package com.example.chatmobile.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.chatmobile.ui.screens.*
import com.example.messenger.ui.screens.SettingsScreen

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "chats"
    ) {
        composable("chats") {
            ChatListScreen(navController)
        }

        composable("profile") {
            ProfileScreen(navController)
        }

        composable("settings") {
            SettingsScreen(navController)
        }

        // Новый маршрут с chatId
        composable(
            route = "chat/{chatId}/{username}",
            arguments = listOf(
                navArgument("chatId") { type = NavType.StringType },
                navArgument("username") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val chatId = backStackEntry.arguments?.getString("chatId") ?: ""
            val username = backStackEntry.arguments?.getString("username") ?: ""

            ChatScreen(
                navController = navController,
                chatId = chatId,
                username = username
            )
        }
    }
}