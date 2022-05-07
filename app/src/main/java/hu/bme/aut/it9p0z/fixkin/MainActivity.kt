package hu.bme.aut.it9p0z.fixkin

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import hu.bme.aut.it9p0z.fixkin.data.repository.Repository
import hu.bme.aut.it9p0z.fixkin.navigation.NavigationGraph
import hu.bme.aut.it9p0z.fixkin.presentation.screens.splash.SplashViewModel
import hu.bme.aut.it9p0z.fixkin.ui.theme.FixkinTheme
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var splashViewModel: SplashViewModel

    @OptIn(ExperimentalMaterialApi::class)
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
