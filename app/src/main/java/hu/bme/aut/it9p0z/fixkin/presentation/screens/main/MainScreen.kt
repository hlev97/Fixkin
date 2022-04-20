package hu.bme.aut.it9p0z.fixkin.presentation.screens.main

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import hu.bme.aut.it9p0z.fixkin.navigation.MainScreenNavigationGraph
import hu.bme.aut.it9p0z.fixkin.navigation.Screen
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history.bottom_navigation.BottomNav
import kotlinx.coroutines.launch

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

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        bottomBar = {
            BottomNav(
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
    ) {
        ModalBottomSheetLayout(
            sheetShape = RoundedCornerShape(15.dp),
            sheetBackgroundColor = Color.White,
            modifier = Modifier,
            sheetState = sheetState,
            sheetContent = {
                LazyColumn(
                    modifier = Modifier
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
