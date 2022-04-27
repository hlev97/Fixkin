package hu.bme.aut.it9p0z.fixkin.presentation.screens.main

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
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
import hu.bme.aut.it9p0z.fixkin.navigation.MainScreenNavigationGraph
import hu.bme.aut.it9p0z.fixkin.navigation.Screen
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.component.MainTopAppBar
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.component.bottom_navigation.BottomNav
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("StateFlowValueCalledInComposition")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val allConditionLogs = mainViewModel.allConditionLogs.value
    val mainNavController = rememberNavController()

    val openMenu = remember { mutableStateOf(false) }

    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

    val bottomBarHeight = 55.dp
    val bottomBarHeightPx = with(LocalDensity.current) {
        bottomBarHeight.roundToPx().toFloat()
    }
    val bottomBarOffsetHeightPx = remember { mutableStateOf(0f) }

    val onStatistics by remember { mutableStateOf(false) }
    val state = remember { mutableStateOf(0) }

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
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxWidth().nestedScroll(nestedScrollConnection),
        topBar = {
            MainTopAppBar(
                modifier = Modifier,
                openSideBar = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
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
                }
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
                Icon(imageVector = if (openMenu.value) Icons.Filled.Close else Icons.Filled.Add, contentDescription = "")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        drawerContent = {
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
                    .fillMaxWidth(0.9f),
                onClick = {  },
                content = { Text("Diary") }
            )
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
                    .fillMaxWidth(0.9f),
                onClick = {  },
                content = { Text("Gallery") }
            )
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
                    .fillMaxWidth(0.9f),
                onClick = {  },
                content = { Text("Settings") }
            )
        }
    ) {
        ModalBottomSheetLayout(
            sheetShape = RoundedCornerShape(15.dp),
            sheetBackgroundColor = Color.White,
            sheetState = sheetState,
            sheetContent = {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 80.dp)
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
                allConditionLogs = allConditionLogs
            )
        }
    }
}
