package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.navigation.Screen
import hu.bme.aut.it9p0z.fixkin.presentation.viewmodels.main.MainViewModel
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history.content.EmptyContent
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history.content.ListContent
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@ExperimentalMaterialApi
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HistoryScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
    navController: NavHostController,
    allConditionLogs: List<ConditionLog>
) {
    if (allConditionLogs.isEmpty()) {
        EmptyContent()
    } else {
        ListContent(
            allConditionLogs = allConditionLogs,
            onClick = { id ->
                navController.navigate(Screen.CheckConditionLog.passId(id))
            },
            onDelete = { log ->
                if (!is24HourBetween(log) ) mainViewModel.decrementDailyConditionLogCounter()
                mainViewModel.deleteConditionLog(log)
            }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun is24HourBetween(log: ConditionLog): Boolean
        = ChronoUnit.HOURS.between(log.date, LocalDateTime.now()) >= 24