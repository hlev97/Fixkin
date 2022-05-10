package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics.data

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import hu.bme.aut.it9p0z.fixkin.R
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants
import hu.ma.charts.legend.data.LegendEntry
import kotlin.math.roundToInt

val foodTriggerCategories = listOf(
    R.string.gluten,
    R.string.milk,
    R.string.lactose,
    R.string.egg,
    R.string.soy,
    R.string.nightshade_vegetable,
    R.string.citrus_fruit,
    R.string.fast_food,
    R.string.fatty_food,
    R.string.alcohol
)

val weatherTriggerCategories = listOf(
    R.string.hot,
    R.string.dry,
    R.string.cold,
    R.string.rainy,
    R.string.windy,
    R.string.snowy,
    R.string.cold_weather_front,
    R.string.warm_weather_front
)

val mentalHealthTriggerCategories = listOf(
    R.string.anxiety,
    R.string.depression,
    R.string.insomnia
)

val otherTriggerCategories = listOf(
    R.string.medicine,
    R.string.infection,
    R.string.smoking,
    R.string.sweat
)

fun foodTriggerFrequency(allConditionLogs: List<ConditionLog>): MutableList<Float> {
    val foodTriggerCounters: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
    allConditionLogs.forEach { log ->
        if (
            log.feeling == ConditionLog.Feeling.feeling_1 ||
            log.feeling == ConditionLog.Feeling.feeling_2 ||
            log.feeling == ConditionLog.Feeling.feeling_3
        ) {
            if(log.food_trigger_1 == 1) {
                foodTriggerCounters[0]++
            }
            if (log.food_trigger_1 == 1) {
                foodTriggerCounters[0]++
            }
            if (log.food_trigger_2 == 1) {
                foodTriggerCounters[1]++
            }
            if (log.food_trigger_3 == 1) {
                foodTriggerCounters[2]++
            }
            if (log.food_trigger_4 == 1) {
                foodTriggerCounters[3]++
            }
            if (log.food_trigger_5 == 1) {
                foodTriggerCounters[4]++
            }
            if (log.food_trigger_6 == 1) {
                foodTriggerCounters[5]++
            }
            if (log.food_trigger_7 == 1) {
                foodTriggerCounters[6]++
            }
            if (log.food_trigger_8 == 1) {
                foodTriggerCounters[7]++
            }
            if (log.food_trigger_9 == 1) {
                foodTriggerCounters[8]++
            }
            if (log.food_trigger_10 == 1) {
                foodTriggerCounters[9]++
            }
        }
    }
    return foodTriggerCounters
}

fun weatherTriggerFrequency(allConditionLogs: List<ConditionLog>): MutableList<Float> {
    val weatherTriggerCounters: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
    allConditionLogs.forEach { log ->
        if (
            log.feeling == ConditionLog.Feeling.feeling_1 ||
            log.feeling == ConditionLog.Feeling.feeling_2 ||
            log.feeling == ConditionLog.Feeling.feeling_3
        ) {
            if (log.weather_trigger_1 == 1) {
                weatherTriggerCounters[0]++
            }
            if (log.weather_trigger_2 == 1) {
                weatherTriggerCounters[1]++
            }
            if (log.weather_trigger_3 == 1) {
                weatherTriggerCounters[2]++
            }
            if (log.weather_trigger_4 == 1) {
                weatherTriggerCounters[3]++
            }
            if (log.weather_trigger_5 == 1) {
                weatherTriggerCounters[4]++
            }
            if (log.weather_trigger_6 == 1) {
                weatherTriggerCounters[5]++
            }
            if (log.weather_trigger_7 == 1) {
                weatherTriggerCounters[6]++
            }
            if (log.weather_trigger_8 == 1) {
                weatherTriggerCounters[7]++
            }
        }
    }
    return weatherTriggerCounters
}

fun mentalHealthTriggerFrequency(allConditionLogs: List<ConditionLog>): MutableList<Float> {
    val mentalTriggerCounters: MutableList<Float> = mutableListOf(0f, 0f, 0f)
    allConditionLogs.forEach { log ->
        if (
            log.feeling == ConditionLog.Feeling.feeling_1 ||
            log.feeling == ConditionLog.Feeling.feeling_2 ||
            log.feeling == ConditionLog.Feeling.feeling_3
        ) {
            if (log.mental_health_trigger_1 == 1) {
                mentalTriggerCounters[0]++
            }
            if (log.mental_health_trigger_2 == 1) {
                mentalTriggerCounters[1]++
            }
            if (log.mental_health_trigger_3 == 1) {
                mentalTriggerCounters[2]++
            }
        }
    }
    return mentalTriggerCounters
}

fun otherTriggerFrequency(allConditionLogs: List<ConditionLog>): MutableList<Float> {
    val otherTriggerCounters: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f)
    allConditionLogs.forEach { log ->
        if (
            log.feeling == ConditionLog.Feeling.feeling_1 ||
            log.feeling == ConditionLog.Feeling.feeling_2 ||
            log.feeling == ConditionLog.Feeling.feeling_3
        ) {
            if (log.other_trigger_1 == 1) {
                otherTriggerCounters[0]++
            }
            if (log.other_trigger_2 == 1) {
                otherTriggerCounters[1]++
            }
            if (log.other_trigger_3 == 1) {
                otherTriggerCounters[2]++
            }
            if (log.other_trigger_4 == 1) {
                otherTriggerCounters[3]++
            }
        }
    }
    return otherTriggerCounters
}

fun nullFloatList(list: MutableList<Float>): Boolean {
    var nullFloatList = true
    for (num in list) {
        if (num != 0f) nullFloatList = false
    }
    return nullFloatList
}

@Composable
internal fun buildValuePercentString(item: LegendEntry) = buildAnnotatedString {
    item.value?.let { value ->
        withStyle(
            style = MaterialTheme.typography.body2.toSpanStyle()
                .copy(color = MaterialTheme.colors.primary)
        ) {
            append(value.toInt().toString())
        }
        append(" ")
    }

    withStyle(
        style = MaterialTheme.typography.caption.toSpanStyle()
            .copy(color = MaterialTheme.colors.secondary)
    ) {
        val percentString = item.percent.roundToInt().toString()
        append("($percentString %)")
    }
}

