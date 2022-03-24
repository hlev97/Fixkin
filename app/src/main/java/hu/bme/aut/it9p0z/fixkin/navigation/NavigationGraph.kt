package hu.bme.aut.it9p0z.fixkin.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.MainScreen
import hu.bme.aut.it9p0z.fixkin.presentation.screens.welcome.WelcomeScreen


@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Welcome.screen_route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Main.screen_route) {
            MainScreen()
        }
    }
}