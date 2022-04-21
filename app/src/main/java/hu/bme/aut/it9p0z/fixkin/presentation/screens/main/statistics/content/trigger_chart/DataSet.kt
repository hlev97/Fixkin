package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics.content.trigger_chart

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics.data.countFoodTriggerFrequency
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.food_trigger_1
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.food_trigger_10
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.food_trigger_2
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.food_trigger_3
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.food_trigger_4
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.food_trigger_5
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.food_trigger_6
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.food_trigger_7
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.food_trigger_8
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.food_trigger_9
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.mental_health_trigger_1
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.mental_health_trigger_2
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.mental_health_trigger_3
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.other_trigger_1
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.other_trigger_2
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.other_trigger_3
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.other_trigger_4
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.weather_trigger_1
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.weather_trigger_2
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.weather_trigger_3
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.weather_trigger_4
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.weather_trigger_5
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.weather_trigger_6
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.weather_trigger_7
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants.weather_trigger_8
import hu.ma.charts.legend.data.LegendPosition
import hu.ma.charts.pie.data.PieChartData
import hu.ma.charts.pie.data.PieChartEntry

val SimpleColors = listOf(
    Color.Black,
    Color.Blue,
    Color.Yellow,
    Color.Red,
    Color.LightGray,
    Color.Magenta,
    Color.Cyan,
    Color.Green,
    Color.Gray,
    Color.DarkGray
)

fun triggersData(
    triggerFrequency: MutableList<Float>,
    triggerCategories: List<String>
): PieChartData {
    return  PieChartData(
        entries = triggerFrequency.mapIndexed { idx, value ->
            PieChartEntry(
                value = value,
                label = AnnotatedString(triggerCategories[idx])
            )
        },
        colors = SimpleColors,
        legendPosition = LegendPosition.Bottom,
        legendShape = CircleShape,
    )
}

