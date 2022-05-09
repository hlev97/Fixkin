package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history

import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.navigation.Screen
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.MainViewModel
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history.content.EmptyContent
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history.content.ListContent

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
                mainViewModel.deleteConditionLog(log)
            }
        )
    }
}