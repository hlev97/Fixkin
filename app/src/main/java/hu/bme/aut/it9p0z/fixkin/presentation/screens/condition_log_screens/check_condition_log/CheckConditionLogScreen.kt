package hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.check_condition_log

import android.annotation.SuppressLint
import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import hu.bme.aut.it9p0z.fixkin.R
import hu.bme.aut.it9p0z.fixkin.navigation.Screen
import hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.ConditionLogView
import hu.bme.aut.it9p0z.fixkin.presentation.viewmodels.condition_log_screens.check_condition_log.CheckConditionLogViewModel
import hu.bme.aut.it9p0z.fixkin.util.feelingToFloat
import hu.bme.aut.it9p0z.fixkin.util.fetchTriggerGroups
import hu.bme.aut.it9p0z.fixkin.util.getConditionLogState
import hu.bme.aut.it9p0z.fixkin.util.sliderPositionToFeeling

@SuppressLint("StateFlowValueCalledInComposition")
@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalMaterialApi
@Composable
fun CheckConditionLogScreen(
    navController: NavHostController,
    checkConditionLogViewModel: CheckConditionLogViewModel = hiltViewModel()
) {
    BackHandler {
        navController.popBackStack()
        navController.navigate(Screen.Main.screen_route)
    }

    val selectedConditionLog = checkConditionLogViewModel.selectedConditionLog.value

    var editable by remember { mutableStateOf(false) }
    val openDialog = remember { mutableStateOf(false) }

    if (selectedConditionLog != null) {
        val triggerGroups = fetchTriggerGroups(selectedConditionLog)
        Scaffold(
            modifier = Modifier
                .fillMaxWidth(),
            topBar = {
                CheckConditionBar(
                    selectedConditionLog = selectedConditionLog,
                    navigateBack = {
                        navController.popBackStack()
                        navController.navigate(Screen.Main.screen_route)
                   },
                    setEditable = { editable = !editable },
                    onDelete = {
                        openDialog.value = true
                    },
                    enabled = editable
                )
            },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                if (editable) {
                    FloatingActionButton(
                        modifier = Modifier,
                        onClick = {
                            val log = getConditionLogState(
                                selectedConditionLog.id,
                                checkConditionLogViewModel.feelingValue,
                                triggerGroups, selectedConditionLog.date
                            )
                            checkConditionLogViewModel.updateConditionLog(log)
                            navController.navigate(Screen.Main.screen_route)
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_save_24),
                            contentDescription = stringResource(id = R.string.save_condition_log_btn)
                        )
                    }
                }
            }
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    item {
                        var sliderPosition by remember { mutableStateOf(feelingToFloat(selectedConditionLog.feeling)) }
                        ConditionLogView(
                            enabled = editable,
                            position = sliderPosition,
                            triggerGroups = triggerGroups,
                            onValueChanged = { pos ->
                                sliderPosition = pos
                            },
                            onValueChangedFinished = {
                                checkConditionLogViewModel.sliderPosition = sliderPosition
                                checkConditionLogViewModel.feelingValue = sliderPositionToFeeling(sliderPosition)
                            }
                        )
                    }
                }
                if (openDialog.value) {
                    AlertDialog(
                        onDismissRequest = { openDialog.value = false },
                        title = { Text("Delete") },
                        text = {
                            Text(text = "Are you sure you want to delete this log?")
                        },
                        confirmButton = {
                            Button(onClick = {
                                checkConditionLogViewModel.deleteConditionLog(
                                    selectedConditionLog
                                )
                                navController.navigate(Screen.Main.screen_route)
                            }) {
                                Text(text = "Delete")
                            }
                        },
                        dismissButton = {
                            Button(onClick = { openDialog.value = false }) {
                                Text(text = "No")
                            }
                        }
                    )
                }
            }
        }
    }
}

