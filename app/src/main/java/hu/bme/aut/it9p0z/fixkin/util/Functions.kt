package hu.bme.aut.it9p0z.fixkin.util

import android.os.Build
import androidx.annotation.RequiresApi
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
fun getConditionLogState(id: Int, feeling: ConditionLog.Feeling, triggerGroups: MutableList<TriggerGroup>, date: LocalDateTime): ConditionLog {
    val triggers = triggerGroupListToTriggerList(triggerGroups)
    return ConditionLog(
        id = id,
        date = date,
        feeling = feeling,
        food_trigger_1 = if(triggers[0].selected) 1 else 0,
        food_trigger_2 = if(triggers[1].selected) 1 else 0,
        food_trigger_3 = if(triggers[2].selected) 1 else 0,
        food_trigger_4 = if(triggers[3].selected) 1 else 0,
        food_trigger_5 = if(triggers[4].selected) 1 else 0,
        food_trigger_6 = if(triggers[5].selected) 1 else 0,
        food_trigger_7 = if(triggers[6].selected) 1 else 0,
        food_trigger_8 = if(triggers[7].selected) 1 else 0,
        food_trigger_9 = if(triggers[8].selected) 1 else 0,
        food_trigger_10 = if(triggers[9].selected) 1 else 0,
        weather_trigger_1 = if(triggers[10].selected) 1 else 0,
        weather_trigger_2 = if(triggers[11].selected) 1 else 0,
        weather_trigger_3 = if(triggers[12].selected) 1 else 0,
        weather_trigger_4 = if(triggers[13].selected) 1 else 0,
        weather_trigger_5 = if(triggers[14].selected) 1 else 0,
        weather_trigger_6 = if(triggers[15].selected) 1 else 0,
        weather_trigger_7 = if(triggers[16].selected) 1 else 0,
        weather_trigger_8 = if(triggers[17].selected) 1 else 0,
        mental_health_trigger_1 = if(triggers[18].selected) 1 else 0,
        mental_health_trigger_2 = if(triggers[19].selected) 1 else 0,
        mental_health_trigger_3 = if(triggers[20].selected) 1 else 0,
        other_trigger_1 = if(triggers[21].selected) 1 else 0,
        other_trigger_2 = if(triggers[22].selected) 1 else 0,
        other_trigger_3 = if(triggers[23].selected) 1 else 0,
        other_trigger_4 = if(triggers[24].selected) 1 else 0
    )
}

fun triggerGroupListToTriggerList(triggerGroups: List<TriggerGroup>): List<Trigger>  {
    val triggers = mutableListOf<Trigger>()
    triggerGroups.forEach { triggerGroup ->
        triggerGroup.triggers.forEach { trigger ->
            triggers.add(trigger)
        }
    }
    return triggers;
}

fun sliderPositionToFeeling(sliderPosition: Float): ConditionLog.Feeling = when (sliderPosition.toInt()) {
    0 -> { ConditionLog.Feeling.feeling_1 }
    1 -> { ConditionLog.Feeling.feeling_2 }
    2 -> { ConditionLog.Feeling.feeling_3 }
    3 -> { ConditionLog.Feeling.feeling_4 }
    4 -> { ConditionLog.Feeling.feeling_5 }
    else -> { ConditionLog.Feeling.feeling_1 }
}

fun feelingToSliderPosition(feeling: ConditionLog.Feeling): Float = when(feeling) {
    ConditionLog.Feeling.feeling_1 -> 0f
    ConditionLog.Feeling.feeling_2 -> 1f
    ConditionLog.Feeling.feeling_3 -> 2f
    ConditionLog.Feeling.feeling_4 -> 3f
    ConditionLog.Feeling.feeling_5 -> 4f
}

fun feelingToFloat(feeling: ConditionLog.Feeling): Float = when(feeling) {
    ConditionLog.Feeling.feeling_1 -> 0f
    ConditionLog.Feeling.feeling_2 -> 1f
    ConditionLog.Feeling.feeling_3 -> 2f
    ConditionLog.Feeling.feeling_4 -> 3f
    ConditionLog.Feeling.feeling_5 -> 4f
}

fun fetchTriggerGroups(log: ConditionLog): MutableList<TriggerGroup> {
    val triggerGroups: MutableList<TriggerGroup> = mutableListOf()

    val foodTriggerGroup = FoodTriggerGroup()
    val foodTriggers = foodTriggerGroup.triggers
    foodTriggers[0].selected = intToBoolean(log.food_trigger_1)
    foodTriggers[1].selected = intToBoolean(log.food_trigger_2)
    foodTriggers[2].selected = intToBoolean(log.food_trigger_2)
    foodTriggers[3].selected = intToBoolean(log.food_trigger_4)
    foodTriggers[5].selected = intToBoolean(log.food_trigger_6)
    foodTriggers[6].selected = intToBoolean(log.food_trigger_7)
    foodTriggers[7].selected = intToBoolean(log.food_trigger_8)
    foodTriggers[8].selected = intToBoolean(log.food_trigger_9)
    foodTriggers[9].selected = intToBoolean(log.food_trigger_10)
    triggerGroups.add(foodTriggerGroup)

    val weatherTriggerGroup = WeatherTriggerGroup()
    val weatherTriggers = weatherTriggerGroup.triggers
    weatherTriggers[0].selected = intToBoolean(log.weather_trigger_1)
    weatherTriggers[1].selected = intToBoolean(log.weather_trigger_2)
    weatherTriggers[2].selected = intToBoolean(log.weather_trigger_3)
    weatherTriggers[3].selected = intToBoolean(log.weather_trigger_4)
    weatherTriggers[4].selected = intToBoolean(log.weather_trigger_5)
    weatherTriggers[5].selected = intToBoolean(log.weather_trigger_6)
    weatherTriggers[6].selected = intToBoolean(log.weather_trigger_7)
    weatherTriggers[7].selected = intToBoolean(log.weather_trigger_8)
    triggerGroups.add(weatherTriggerGroup)

    val mentalHealthTriggerGroup = MentalHealthTriggerGroup()
    val mentalHealthTriggers = mentalHealthTriggerGroup.triggers
    mentalHealthTriggers[0].selected = intToBoolean(log.mental_health_trigger_1)
    mentalHealthTriggers[1].selected = intToBoolean(log.mental_health_trigger_2)
    mentalHealthTriggers[2].selected = intToBoolean(log.mental_health_trigger_3)
    triggerGroups.add(mentalHealthTriggerGroup)

    val otherTriggerGroup = OtherTriggerGroup()
    val otherTriggers = otherTriggerGroup.triggers
    otherTriggers[0].selected = intToBoolean(log.other_trigger_1)
    otherTriggers[1].selected = intToBoolean(log.other_trigger_2)
    otherTriggers[2].selected = intToBoolean(log.other_trigger_3)
    otherTriggers[3].selected = intToBoolean(log.other_trigger_4)
    triggerGroups.add(otherTriggerGroup)

    return triggerGroups
}

private fun intToBoolean(int: Int): Boolean = when(int) {
    0 -> false
    1 -> true
    else -> false
}