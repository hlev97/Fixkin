package hu.bme.aut.it9p0z.fixkin.presentation.screens.main

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import hu.bme.aut.it9p0z.fixkin.navigation.MainScreenNavigationGraph
import hu.bme.aut.it9p0z.fixkin.navigation.Screen
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.component.MainTopAppBar
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.component.bottom_navigation.BottomNav
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@ExperimentalMaterialApi
@ExperimentalPagerApi
@SuppressLint("StateFlowValueCalledInComposition")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val allConditionLogs = mainViewModel.allConditionLogs.value
    val allLifeQualityTestResultLogs = mainViewModel.allLifeQualityTestResultLogs.value
    val mainNavController = rememberNavController()

    val openMenu = remember { mutableStateOf(false) }

    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    val bottomBarHeight = 55.dp
    val bottomBarHeightPx = with(LocalDensity.current) {
        bottomBarHeight.roundToPx().toFloat()
    }
    val bottomBarOffsetHeightPx = remember { mutableStateOf(0f) }

    val transition: Transition<Boolean> = updateTransition(targetState = openMenu.value, label = "Menu visibility changed")
    val rotation: Float by transition
        .animateFloat(label = "") { opened ->
            if (opened) 315f else 0f
        }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                val delta = available.y
                val newOffsetForBottomAppBar = bottomBarOffsetHeightPx.value + delta
                bottomBarOffsetHeightPx.value =
                    newOffsetForBottomAppBar.coerceIn(-bottomBarHeightPx, 0f)
                return Offset.Zero
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxWidth().nestedScroll(nestedScrollConnection),
        topBar = {
            MainTopAppBar(
                modifier = Modifier
            )
        },
        bottomBar = {
            BottomNav(
                modifier = Modifier
                    .height(bottomBarHeight)
                    .offset {
                        IntOffset(
                            x = 0,
                            y = -bottomBarOffsetHeightPx.value.roundToInt())
                    },
                navController = mainNavController,
                onClick = {
                    openMenu.value = false
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                openMenu.value = !openMenu.value
                scope.launch {
                    if (openMenu.value) {
                        sheetState.show()
                    } else {
                        sheetState.hide()
                    }
                }
            }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "",
                    modifier = Modifier.rotate(rotation)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        ModalBottomSheetLayout(
            sheetShape = RoundedCornerShape(15.dp),
            sheetState = sheetState,
            sheetContent = {
                LazyColumn(
                    modifier = Modifier
                        .padding(bottom = 75.dp)
                        .align(Alignment.CenterHorizontally),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Button(
                            modifier = Modifier
                                .padding(horizontal = 15.dp)
                                .padding(top = 15.dp),
                            onClick = { navController.navigate(Screen.AddConditionLog.screen_route) }
                        ) {
                            Text(text = "Add Condition Log")
                        }
                    }

                    item {
                        Button(
                            modifier = Modifier
                                .padding(horizontal = 15.dp)
                                .padding(bottom = 15.dp),
                            onClick = { navController.navigate(Screen.LifeQualityTest.screen_route) }
                        ) {
                            Text(text = "Fill out DLQI Survey")
                        }
                    }
                }
            }
        ) {
            MainScreenNavigationGraph(
                mainNavController = mainNavController,
                navController = navController,
                allConditionLogs = allConditionLogs,
                result = allLifeQualityTestResultLogs
            )
        }
    }
}
