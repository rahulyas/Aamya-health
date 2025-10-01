package com.rahul.aamyahealth.domain

sealed class BottomNavItem(
    val route: String,
    val label: String
) {
    data object Home : BottomNavItem(route = "home", label = "Home")
    data object Messages : BottomNavItem(route = "messages", label = "Messages")
    data object Add : BottomNavItem(route = "add", label = "Add")
    data object Schedule : BottomNavItem(route = "schedule", label = "Schedule")
    data object Profile : BottomNavItem(route = "profile", label = "Profile")
}