package com.calyrsoft.ucbp1.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Github: Screen("github")
    object Profile: Screen("profile")
    object Login: Screen("login")
    object Movies: Screen("movies")
    object Dollar: Screen("dollar")
}