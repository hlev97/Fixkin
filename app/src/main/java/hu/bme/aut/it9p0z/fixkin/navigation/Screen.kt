package hu.bme.aut.it9p0z.fixkin.navigation

sealed class Screen (
    val screen_route: String
) {
    object Welcome : Screen("welcome")
    object Main : Screen("main")
    object LifeQualityTest: Screen("test")
}