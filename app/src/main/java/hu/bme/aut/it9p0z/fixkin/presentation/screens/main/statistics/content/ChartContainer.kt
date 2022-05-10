package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import hu.ma.charts.legend.data.LegendEntry
import kotlin.math.roundToInt

@Composable
fun ChartContainer(
    modifier: Modifier = Modifier,
    title: String,
    chartOffset: Dp = 12.dp,
    content: @Composable () -> Unit,
) {
    Column(modifier = modifier) {
        Text(title, style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.requiredSize(chartOffset))
        content()
    }
}

@Composable
internal fun buildValuePercentString(item: LegendEntry) = buildAnnotatedString {
    item.value?.let { value ->
        withStyle(
            style = MaterialTheme.typography.body2.toSpanStyle()
                .copy(color = MaterialTheme.colors.primary)
        ) {
            append(value.toInt().toString())
        }
        append(" ")
    }

    withStyle(
        style = MaterialTheme.typography.caption.toSpanStyle()
            .copy(color = MaterialTheme.colors.secondary)
    ) {
        val percentString = item.percent.roundToInt().toString()
        append("($percentString %)")
    }
}