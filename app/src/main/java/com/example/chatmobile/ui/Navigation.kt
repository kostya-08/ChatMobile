package com.example.chatmobile.ui
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavHostController
import com.example.chatmobile.ui.screens.ChatListScreen
import com.example.chatmobile.ui.screens.ChatScreen
import com.example.chatmobile.ui.screens.ProfileScreen
import com.example.messenger.ui.screens.SettingsScreen

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "chats"
    ) {

        composable("profile") {
            ProfileScreen(navController)
        }

        composable("chats") {
            ChatListScreen(navController)
        }

        composable("settings") {
            SettingsScreen(navController)
        }

        composable(
            "chat/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                }
            )
        ) { backStack ->

            val name = backStack.arguments?.getString("name") ?: ""

            ChatScreen(
                navController = navController,
                username = name
            )
        }
    }
}