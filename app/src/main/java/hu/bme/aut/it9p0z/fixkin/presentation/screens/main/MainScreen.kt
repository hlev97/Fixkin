package hu.bme.aut.it9p0z.fixkin.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import hu.bme.aut.it9p0z.fixkin.navigation.Screen

@Composable
fun MainScreen(
    navController: NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "This is the Main screen",
            fontSize = 28.sp
        )
        Button(onClick = { navController.navigate(Screen.LifeQualityTest.screen_route) }) {

        }
    }
}