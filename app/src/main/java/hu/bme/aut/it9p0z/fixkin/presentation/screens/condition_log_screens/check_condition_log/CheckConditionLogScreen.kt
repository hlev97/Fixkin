package hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.check_condition_log

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import hu.bme.aut.it9p0z.fixkin.navigation.Screen
import hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.component.ConditionLogView
import hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.util.getConditionLogState
import hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.util.*

@SuppressLint("StateFlowValueCalledInComposition")
@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalMaterialApi
@Composable
fun CheckConditionLogScreen(
    navController: NavHostController,
    checkConditionLogViewModel: CheckConditionLogViewModel = hiltViewModel()
) {
    BackHandler {
        navController.navigate(Screen.Main.screen_route)
    }

    val selectedConditionLog = checkConditionLogViewModel.selectedConditionLog.value
    if (selectedConditionLog != null) {
        Log.i("${selectedConditionLog.date}", "null check")
    }

    var editable by remember { mutableStateOf(false) }
    val openDialog = remember { mutableStateOf(false)  }

    if (selectedConditionLog != null) {
        val triggerGroups = fetchTriggerGroups(selectedConditionLog)
        Scaffold(
            modifier = Modifier
                .fillMaxWidth(),
            topBar = { CheckConditionBar(
                selectedConditionLog = selectedConditionLog,
                navigateBack = { navController.navigate(Screen.Main.screen_route) },
                setEditable = { editable = !editable },
                onDelete = {
                    openDialog.value = true
                },
                enabled = editable
            )},
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        if (editable) {
                            val log = getConditionLogState(
                                selectedConditionLog.id,
                                checkConditionLogViewModel.feelingValue,
                                triggerGroups, selectedConditionLog.date
                            )
                            checkConditionLogViewModel.updateConditionLog(log)
                            navController.navigate(Screen.Main.screen_route)
                        }
                    }
                ) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "")
                }
            }
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                ) {
                    item {
                        ConditionLogView(
                            enabled = editable,
                            position = feelingToFloat(selectedConditionLog.feeling),
                            triggerGroups = triggerGroups,
                            onClick = {

                            },
                            checkConditionLogViewModel = checkConditionLogViewModel
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


