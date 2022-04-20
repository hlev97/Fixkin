package hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.check_condition_log.util

abstract class TriggerGroup constructor(val title: String, val triggers: List<Trigger>)

class FoodTriggerGroup : TriggerGroup(
    title = "Food Triggers",
    triggers = listOf(
        Gluten(),
        Milk(),
        Lactose(),
        Egg(),
        Soy(),
        NightShade(),
        CitrusFruit(),
        FastFood(),
        FattyFoods(),
        Alcohol()
    )
)
class WeatherTriggerGroup : TriggerGroup(
    title = "Weather Triggers",
    triggers = listOf(
        Hot(),
        Dry(),
        Cold(),
        Rainy(),
        Windy(),
        Snowy(),
        ColdFront(),
        WarmFront()
    )
)
class MentalHealthTriggerGroup : TriggerGroup(
    title = "Mental Health Trigger",
    triggers = listOf(
        Anxiety(),
        Depression(),
        Insomnia()
    )
)
class OtherTriggerGroup : TriggerGroup(
    title = "Other triggers",
    triggers = listOf(
        Medicine(),
        Infection(),
        Smoking(),
        Sweat()
    )
)