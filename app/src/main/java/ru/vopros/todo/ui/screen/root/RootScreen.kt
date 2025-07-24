package ru.vopros.todo.ui.screen.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.vopros.todo.ui.screen.Main
import ru.vopros.todo.ui.screen.Splash
import ru.vopros.todo.ui.screen.main.MainScreen

@Composable
fun RootScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Splash
    ) {
        composable<Splash> {
            LaunchedEffect(Unit) {
                navController.navigate(Main)
            }
        }
        composable<Main> {
            MainScreen()
        }
    }
}