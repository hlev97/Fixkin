package hu.bme.aut.it9p0z.fixkin.util

import hu.bme.aut.it9p0z.fixkin.R

abstract class Trigger constructor(open var selected: Boolean) {
    open val stringResourceId: Int = 0
}

class Gluten(override var selected: Boolean = false) : Trigger(selected) {
  override val stringResourceId: Int = R.string.gluten
}

class Milk(override var selected: Boolean = false) : Trigger(selected) {
  override val stringResourceId: Int = R.string.milk
}

class Lactose(override var selected: Boolean = false) : Trigger(selected) {
  override val stringResourceId: Int = R.string.lactose
}

class Egg constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.egg
}

class Soy constructor(override var selected: Boolean = false) :  Trigger(selected) {
    override val stringResourceId: Int = R.string.soy
}

class NightShade constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.nightshade_vegetable
}

class CitrusFruit constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.citrus_fruit
}

class FastFood constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.fast_food
}

class FattyFoods constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.fatty_food
}

class Alcohol constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.alcohol
}

class Hot constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.hot

}

class Dry constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.dry
}

class Cold constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.cold
}

class Rainy constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.rainy
}

class Windy constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.windy
}

class Snowy constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.snowy
}

class ColdFront constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.cold_weather_front
}

class WarmFront constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.warm_weather_front
}

class Anxiety constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.anxiety
}

class Depression constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.depression
}

class Insomnia constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.insomnia
}

class Medicine constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.medicine
}

class Infection constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int =R.string.infection
}

class Smoking constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.smoking
}

class Sweat constructor(override var selected: Boolean = false) : Trigger(selected) {
    override val stringResourceId: Int = R.string.sweat
}
