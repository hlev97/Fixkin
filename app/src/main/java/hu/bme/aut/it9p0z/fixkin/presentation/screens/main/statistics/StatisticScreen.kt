package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog

@Composable
fun StatisticsScreen(
    allConditionLogs: List<ConditionLog>
) {
    Column {
        Text(text = "Statistics")
    }
}