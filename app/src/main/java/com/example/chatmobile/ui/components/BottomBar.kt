package com.example.chatmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chatmobile.R

@Composable
fun BottomBar(
    navController: NavController,
    selected: String
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(35.dp))
                .border(
                    width = 3.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(35.dp)
                )
                .background(Color(0xFFFFC107))
                .padding(horizontal = 24.dp, vertical = 10.dp)
                .fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = {
                    navController.navigate("profile")
                }
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    tint = Color.Black
                )
            }

            IconButton(
                onClick = {
                    navController.navigate("chats")
                }
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.chat),
                    contentDescription = null,
                    tint = Color.Black
                )
            }

            IconButton(
                onClick = {
                    navController.navigate("settings")
                }
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.setting),
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }
}