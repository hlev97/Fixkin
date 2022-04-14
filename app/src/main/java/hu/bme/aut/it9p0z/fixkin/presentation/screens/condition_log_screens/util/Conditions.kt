package hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.util

import hu.bme.aut.it9p0z.fixkin.R
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

sealed class Trigger(val title: String, var selected: Boolean) {
    object Gluten : Trigger(title = food_trigger_1, selected = false)
    object Milk : Trigger(title = food_trigger_2, selected = false)
    object Lactose : Trigger(title = food_trigger_3, selected = false)
    object Egg : Trigger(title = food_trigger_4, selected = false)
    object Soy : Trigger(title = food_trigger_5, selected = false)
    object NightShade : Trigger(title = food_trigger_6, selected = false)
    object CitrusFruit : Trigger(title = food_trigger_7, selected = false)
    object FastFood : Trigger(title = food_trigger_8, selected = false)
    object FattyFoods : Trigger(title = food_trigger_9, selected = false)
    object Alcohol : Trigger(title = food_trigger_10, selected = false)

    object Hot : Trigger(title = weather_trigger_1, selected = false)
    object Dry : Trigger(title = weather_trigger_2, selected = false)
    object Cold : Trigger(title = weather_trigger_3, selected = false)
    object Rainy : Trigger(title = weather_trigger_4, selected = false)
    object Windy : Trigger(title = weather_trigger_5, selected = false)
    object Snowy : Trigger(title = weather_trigger_6, selected = false)
    object ColdFront : Trigger(title = weather_trigger_7, selected = false)
    object WarmFront : Trigger(title = weather_trigger_8, selected = false)

    object Anxiety : Trigger(title = mental_health_trigger_1, selected = false)
    object Depression : Trigger(title = mental_health_trigger_2, selected = false)
    object Insomnia : Trigger(title = mental_health_trigger_3, selected = false)

    object Medicine : Trigger(title = other_trigger_1, selected = false)
    object Infection : Trigger(title = other_trigger_2, selected = false)
    object Smoking : Trigger(title = other_trigger_3, selected = false)
    object Sweat : Trigger(title = other_trigger_4, selected = false)
}

sealed class TriggerGroup(val title: String, val triggers: List<Trigger>) {
    object FoodTriggerGroup : TriggerGroup(
        title = "Food Triggers",
        triggers = listOf(Trigger.Gluten, Trigger.Milk, Trigger.Lactose, Trigger.Egg, Trigger.Soy, Trigger.NightShade, Trigger.CitrusFruit, Trigger.FastFood, Trigger.FattyFoods, Trigger.Alcohol)
    )
    object WeatherTriggerGroup : TriggerGroup(
        title = "Weather Triggers",
        triggers = listOf(Trigger.Hot, Trigger.Dry, Trigger.Cold, Trigger.Rainy, Trigger.Windy, Trigger.Snowy, Trigger.ColdFront, Trigger.WarmFront)
    )
    object MentalHealthTriggerGroup : TriggerGroup(
        title = "Mental Health Trigger",
        triggers = listOf(Trigger.Anxiety, Trigger.Depression, Trigger.Insomnia)
    )
    object OtherTriggerGroup : TriggerGroup(
        title = "Other triggers",
        triggers = listOf(Trigger.Medicine, Trigger.Infection, Trigger.Smoking, Trigger.Sweat)
    )
}

val triggerGroups = listOf(
    TriggerGroup.FoodTriggerGroup,
    TriggerGroup.WeatherTriggerGroup,
    TriggerGroup.MentalHealthTriggerGroup,
    TriggerGroup.OtherTriggerGroup
)

sealed class Feeling(val title: String, val iconId: Int) {
    object VeryDissatisfied : Feeling(
        title = "Very dissatisfied",
        iconId = R.drawable.ic_sentiment_very_dissatisfied_black_24dp,
    )
    object Dissatisfied : Feeling(
        title = "Dissatisfied",
        iconId = R.drawable.ic_sentiment_dissatisfied_black_24dp,
    )
    object Neutral : Feeling(
        title = "Neutral",
        iconId = R.drawable.ic_sentiment_neutral_black_24dp,
    )
    object Satisfied : Feeling(
        title = "Satisfied",
        iconId = R.drawable.ic_sentiment_satisfied_black_24dp,
    )
    object VerySatisfied : Feeling(
        title = "Very satisfied",
        iconId = R.drawable.ic_sentiment_very_satisfied_black_24dp,
    )
}

val feelings = listOf(
    Feeling.VeryDissatisfied,
    Feeling.Dissatisfied,
    Feeling.Neutral,
    Feeling.Satisfied,
    Feeling.VerySatisfied
)