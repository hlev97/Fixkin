package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.navigation.Screen
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history.content.EmptyContent
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history.content.ListContent

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HistoryScreen(
    mainNavController: NavHostController,
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
            }
        )
    }
}