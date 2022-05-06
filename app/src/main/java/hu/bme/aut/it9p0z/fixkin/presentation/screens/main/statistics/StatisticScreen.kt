package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.data.model.LifeQualityTestResultLog
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics.content.trigger_chart.getLineData
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics.content.trigger_chart.triggersData
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics.data.*
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics.pages.LinesSimpleScreen
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics.pages.TabScreen
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun StatisticsScreen(
    allConditionLogs: List<ConditionLog>,
    result: List<LifeQualityTestResultLog>
) {
    val pagerState = rememberPagerState(0)
    val list = listOf("Food", "Weather", "Mental Health", "Other", "DLQI")

    Column(modifier = Modifier.fillMaxWidth()) {
        Tabs(pagerState = pagerState, list)
        TabsContent(pagerState = pagerState, list.size, allConditionLogs, result)
    }
}

@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState, tabs: List<String>) {
    val scope = rememberCoroutineScope()
    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        contentColor = Color.White,
        divider = {
            TabRowDefaults.Divider(
                thickness = 2.dp,
            )
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.White
            )
        }
    ) {
        tabs.forEachIndexed { index, _->
            Tab(
                text = {
                    Text(
                        tabs[index],
                        color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalPagerApi
@Composable
fun TabsContent(
    pagerState: PagerState,
    size: Int,
    allConditionLogs: List<ConditionLog>,
    result: List<LifeQualityTestResultLog>
) {
    val foodTriggerFrequency = foodTriggerFrequency(allConditionLogs = allConditionLogs);
    val foodTriggerCategories = foodTriggerCategories
    val foodData = triggersData(foodTriggerFrequency, foodTriggerCategories)

    val weatherTriggerFrequency = weatherTriggerFrequency(allConditionLogs = allConditionLogs)
    val weatherTriggerCategories = weatherTriggerCategories
    val weatherData = triggersData(weatherTriggerFrequency, weatherTriggerCategories)

    val mentalTriggerFrequency =  mentalHealthTriggerFrequency(allConditionLogs = allConditionLogs)
    val mentalTriggerCategories = mentalHealthTriggerCategories
    val mentalHealthData = triggersData(mentalTriggerFrequency, mentalTriggerCategories)

    val otherTriggerFrequency =  otherTriggerFrequency(allConditionLogs = allConditionLogs)
    val otherTriggerCategories = otherTriggerCategories
    val otherData = triggersData(otherTriggerFrequency, otherTriggerCategories)

    val data = getLineData(result)

    HorizontalPager(
        state = pagerState,
        count = size
    ) { page ->
        when(page) {
            0 -> TabScreen(foodData)
            1 -> TabScreen(weatherData)
            2 -> TabScreen(mentalHealthData)
            3 -> TabScreen(otherData)
            4 -> LinesSimpleScreen(data)
        }
    }
}

