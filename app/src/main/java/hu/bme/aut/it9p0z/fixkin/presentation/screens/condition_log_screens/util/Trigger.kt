package hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.util

import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants

abstract class Trigger constructor(open var selected: Boolean) {
    open val title: String = ""
}

class Gluten(override var selected: Boolean = false) : Trigger(selected) {
  override val title: String = PersistenceConstants.food_trigger_1
}

class Milk(override var selected: Boolean = false) : Trigger(selected) {
  override val title: String = PersistenceConstants.food_trigger_2
}

class Lactose(override var selected: Boolean = false) : Trigger(selected) {
  override val title: String = PersistenceConstants.food_trigger_3
}

class Egg constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.food_trigger_4
}

class Soy constructor(override var selected: Boolean = false) :  Trigger(selected) {
    override val title: String = PersistenceConstants.food_trigger_5
}

class NightShade constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.food_trigger_6
}

class CitrusFruit constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.food_trigger_7
}

class FastFood constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.food_trigger_7
}

class FattyFoods constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.food_trigger_8
}

class Alcohol constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.food_trigger_9
}

class Hot constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.weather_trigger_1

}

class Dry constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.weather_trigger_2
}

class Cold constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.weather_trigger_3
}

class Rainy constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.weather_trigger_4
}

class Windy constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.weather_trigger_5
}

class Snowy constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.weather_trigger_6
}

class ColdFront constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.weather_trigger_7
}

class WarmFront constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.weather_trigger_8
}

class Anxiety constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.mental_health_trigger_1
}

class Depression constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.mental_health_trigger_2
}

class Insomnia constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.mental_health_trigger_3
}

class Medicine constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.other_trigger_1
}

class Infection constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.other_trigger_2
}

class Smoking constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.other_trigger_3
}

class Sweat constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val title: String = PersistenceConstants.other_trigger_4
}
