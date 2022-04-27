package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history.util
enum class HistoryStatus {
    LOADING, HAS_LOGS, ERROR, EMPTY
}
data class HistoryState(
    val status: HistoryStatus = HistoryStatus.LOADING,
    val content: List<History>? = null
)
