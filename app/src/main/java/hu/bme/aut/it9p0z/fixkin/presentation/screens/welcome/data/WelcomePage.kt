package hu.bme.aut.it9p0z.fixkin.presentation.screens.welcome.data

import hu.bme.aut.it9p0z.fixkin.R

sealed class WelcomePage(
    val illustration: Int,
    val title: String,
    val description: String
) {
    object FirstPage : WelcomePage(
        illustration = R.drawable.illustration_sad,
        title = "You've got enough?",
        description = "Some texty text. Some texty text. Some texty text."
    )

    object SecondPage : WelcomePage(
        illustration = R.drawable.illustration_report,
        title = "Track your triggers.",
        description = "Some texty text. Some texty text. Some texty text."
    )

    object ThirdPage : WelcomePage(
        illustration = R.drawable.illustration_feel_free,
        title = "Set yourself free!",
        description = "Some texty text. Some texty text. Some texty text."
    )
}