package hu.bme.aut.it9p0z.fixkin.navigation

sealed class Screen (
    val screen_route: String
) {
    object Splash : Screen("splash")
    object Welcome : Screen("welcome")
    object Main : Screen("main")
}