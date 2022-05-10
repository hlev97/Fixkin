package hu.bme.aut.it9p0z.fixkin.util

import hu.bme.aut.it9p0z.fixkin.R


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