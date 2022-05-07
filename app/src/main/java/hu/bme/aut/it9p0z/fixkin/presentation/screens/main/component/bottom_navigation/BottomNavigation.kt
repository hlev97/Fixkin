package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.component.bottom_navigation

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import hu.bme.aut.it9p0z.fixkin.ui.theme.bottomNavBarActionSelected
import hu.bme.aut.it9p0z.fixkin.ui.theme.bottomNavBarActionUnselected

@Composable
fun BottomNav(
    modifier: Modifier,
    navController: NavHostController,
    onClick: () -> Unit
) {
    val items = listOf(
        BottomNavigationItem.History,
        BottomNavigationItem.Statistics
    )

    BottomAppBar(
        modifier = modifier,
        cutoutShape = CircleShape
    ) {
        BottomNavigation(modifier = modifier) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    selected = currentRoute == item.screen_route,
                    label = {
                        Text(text = item.title, fontSize = 9.sp)
                    },
                    selectedContentColor = MaterialTheme.colors.bottomNavBarActionSelected,
                    unselectedContentColor = MaterialTheme.colors.bottomNavBarActionUnselected,
                    alwaysShowLabel = true,
                    onClick = {
                        if (item.screen_route != currentRoute) {
                            onClick()
                            navController.navigate(item.screen_route) {
                                navController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    icon = {
                        Icon(painter = painterResource(id = item.icon), contentDescription = "")
                    }
                )
            }
        }
    }
}