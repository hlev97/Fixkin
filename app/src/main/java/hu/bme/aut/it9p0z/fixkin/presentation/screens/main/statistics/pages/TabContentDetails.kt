package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics.pages

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics.content.ChartContainer
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics.data.buildValuePercentString
import hu.ma.charts.legend.data.LegendEntry
import hu.ma.charts.line.LineChart
import hu.ma.charts.line.data.LineChartData
import hu.ma.charts.pie.PieChart
import hu.ma.charts.pie.data.PieChartData

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TabScreen(data: PieChartData) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(
            top = 24.dp,
            bottom = 24.dp,
        ),
    ) {
        item {
            ChartContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .border(
                        BorderStroke(1.dp, Color.LightGray),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
                    .animateContentSize(),
                title = ""
            ) {
                PieChart(
                    data = data,
                    legend = { entries ->
                        CustomVerticalLegend(entries = entries)
                    }
                )
            }
        }
    }
}

@Composable
private fun RowScope.CustomVerticalLegend(entries: List<LegendEntry>) {
    Column(
        modifier = Modifier.weight(1f),
    ) {
        entries.forEachIndexed { idx, item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 14.dp)
            ) {
                Box(
                    Modifier
                        .requiredSize(item.shape.size)
                        .background(item.shape.color, item.shape.shape)
                )

                Spacer(modifier = Modifier.requiredSize(8.dp))

                Text(
                    text = item.text,
                    style = MaterialTheme.typography.caption
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = buildValuePercentString(item),
                    style = MaterialTheme.typography.caption,
                )
            }

            if (idx != entries.lastIndex)
                Divider()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LinesSimpleScreen(
    data: LineChartData
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(
            top = 24.dp,
            bottom = 24.dp,
        ),
    ) {
        item {
            ChartContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .border(
                        BorderStroke(1.dp, Color.LightGray),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
                    .animateContentSize(),
                title = "DLQI test results "
            ) {
                LineChart(
                    chartHeight = 400.dp,
                    data = data
                )
            }
        }
    }
}