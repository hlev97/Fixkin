package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import hu.bme.aut.it9p0z.fixkin.data.model.LifeQualityTestResultLog
import hu.ma.charts.legend.data.LegendPosition
import hu.ma.charts.line.data.LineChartData
import hu.ma.charts.pie.data.PieChartData
import hu.ma.charts.pie.data.PieChartEntry

val SampleColors = listOf(
    Color(0xFF380532),
    Color(0xFF3C2A3C),
    Color(0xFF5A7E87),
    Color(0xFF93A7B4),
    Color(0xFF4B8155),
    Color(0xFF4B5639),
    Color(0xFFB4AD2D),
    Color(0xFF557246),
    Color(0xFF195361),
    Color(0xFF580E20)
)

fun triggersData(
    triggerFrequency: MutableList<Float>,
    triggerCategories: List<String>
): PieChartData {
    return  PieChartData(
        entries = triggerFrequency.mapIndexed { idx, value ->
            PieChartEntry(
                value = value,
                label = AnnotatedString(triggerCategories[idx])
            )
        },
        colors = SampleColors,
        legendPosition = LegendPosition.Bottom,
        legendShape = CircleShape,
    )
}

private fun seriesLifeQuality(
    result: List<LifeQualityTestResultLog>
): List<LineChartData.SeriesData.Point> {
    val series = mutableListOf<LineChartData.SeriesData.Point>()
    result.forEachIndexed { i, log ->
        series.add(i, LineChartData.SeriesData.Point(i, log.lqt_score.toFloat()))
    }
    return series
}

@RequiresApi(Build.VERSION_CODES.O)
private fun xLabels(result: List<LifeQualityTestResultLog>): List<String> {
    val xLabels = mutableListOf<String>()
    result.forEachIndexed { i, log ->
        xLabels.add(i, log.id.toString())
    }
    return xLabels
}

@RequiresApi(Build.VERSION_CODES.O)
fun getLineData(
    result: List<LifeQualityTestResultLog>
) = LineChartData(
    series = listOf(
        LineChartData.SeriesData(
            "",
            points = seriesLifeQuality(result),
            Color(0xFF580E20)
        )
    ),
    xLabels = xLabels(result),
)