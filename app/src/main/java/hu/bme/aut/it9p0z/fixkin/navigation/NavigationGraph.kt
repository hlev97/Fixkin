package hu.bme.aut.it9p0z.fixkin.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.accompanist.pager.ExperimentalPagerApi
import hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.add_condition_log.AddConditionLogScreen
import hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.check_condition_log.CheckConditionLogScreen
import hu.bme.aut.it9p0z.fixkin.presentation.screens.life_quality_test.LifeQualityTestScreen
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.MainScreen
import hu.bme.aut.it9p0z.fixkin.presentation.screens.welcome.WelcomeScreen


@OptIn(ExperimentalMaterialApi::class)
@RequiresApi(Build.VERSION_CODES.O)
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
            MainScreen(navController = navController)
        }
        composable(route = Screen.LifeQualityTest.screen_route) {
            LifeQualityTestScreen(navController = navController)
        }
        composable(route = Screen.AddConditionLog.screen_route) {
            AddConditionLogScreen(navController = navController)
        }
        composable(
            route = Screen.CheckConditionLog.screen_route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) {
            CheckConditionLogScreen(navController = navController)
        }
    }
}