package com.rahul.aamyahealth.presentation.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rahul.aamyahealth.domain.BottomNavItem
import com.rahul.aamyahealth.presentation.components.CustomBottomNavigation

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Messages,
        BottomNavItem.Add,
        BottomNavItem.Schedule,
        BottomNavItem.Profile
    )

    Scaffold(
        bottomBar = {
            CustomBottomNavigation(
                modifier = Modifier,
                navController = navController,
                items = items
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Home.route) {
                HealthcareAppUI()
            }
            composable(BottomNavItem.Messages.route) {
                MessagesScreen()
            }
            composable(BottomNavItem.Add.route) {
                AddScreen()
            }
            composable(BottomNavItem.Schedule.route) {
                ScheduleScreen()
            }
            composable(BottomNavItem.Profile.route) {
                ProfileScreen()
            }
        }
    }
}