package hu.bme.aut.it9p0z.fixkin.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history.HistoryScreen
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history.bottom_navigation.BottomNavigationItem
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics.StatisticsScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreenNavigationGraph(
    mainNavController: NavHostController,
    navController: NavHostController,
    allConditionLogs: List<ConditionLog>
) {
    NavHost(navController = mainNavController, startDestination = BottomNavigationItem.History.screen_route) {
        composable(BottomNavigationItem.History.screen_route) {
            HistoryScreen(mainNavController = mainNavController, allConditionLogs = allConditionLogs, navController = navController)
        }
        composable(BottomNavigationItem.Statistics.screen_route) {
            StatisticsScreen(allConditionLogs = allConditionLogs)
        }
    }
}