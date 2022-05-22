package hu.bme.aut.it9p0z.fixkin

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import hu.bme.aut.it9p0z.fixkin.navigation.NavigationGraph
import hu.bme.aut.it9p0z.fixkin.presentation.viewmodels.splash.SplashViewModel
import hu.bme.aut.it9p0z.fixkin.ui.theme.FixkinTheme
import javax.inject.Inject

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var splashViewModel: SplashViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FixkinTheme {
                val screen by splashViewModel.startDestination
                val navController = rememberNavController()
                NavigationGraph(navController = navController, startDestination = screen)
            }
        }
    }
}
