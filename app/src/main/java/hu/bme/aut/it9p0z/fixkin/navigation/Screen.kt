package hu.bme.aut.it9p0z.fixkin.navigation

sealed class Screen (
    val screen_route: String
) {
    object Welcome : Screen("welcome")
    object Main : Screen("main")
    object LifeQualityTest: Screen("test")
    object AddConditionLog: Screen("add_log")
    object CheckConditionLog: Screen("check_log/{id}") {
        fun passId(id: Int): String {
            return "check_log/$id"
        }
    }
}