package hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.add_condition_log

import android.os.Build
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.flowlayout.FlowRow
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.navigation.Screen
import hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.util.Trigger
import hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.util.TriggerGroup
import hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.util.feelings
import hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.util.triggerGroups
import kotlinx.coroutines.launch
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalMaterialApi
@Composable
fun AddConditionLogScreen(
    navController: NavHostController,
    addConditionLogViewModel: AddConditionLogViewModel = hiltViewModel()
) {
    BackHandler {
        navController.navigate(Screen.Main.screen_route)
    }

    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = {
                    val log = getConditionLogState(addConditionLogViewModel.feelingValue)
                    scope.launch {
                        addConditionLogViewModel.insertConditionLog(log = log)
                    }
                    navController.navigate(Screen.Main.screen_route)
                }
            ) {
                Text(text = "C")
            }
        }
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
        ) {

            var sliderPosition by remember { mutableStateOf(0f) }
            Text(text = "Feeling")
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                valueRange = 0f..4f,
                onValueChangeFinished = {
                    addConditionLogViewModel.feelingValue = sliderPositionToFeeling(sliderPosition)
                },
                steps = 3,
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colors.secondary,
                    activeTrackColor = MaterialTheme.colors.secondary
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                feelings.forEach { feeling ->
                    Icon(painter = painterResource(id = feeling.iconId), contentDescription = feeling.title)
                }
            }

            triggerGroups.forEach { triggerGroup ->
                Text(text = triggerGroup.title)
                FlowRow(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 15.dp)) {
                    triggerGroup.triggers.forEach { trigger ->
                        var selected by remember { mutableStateOf(false) }
                        Chip(
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .selectable(
                                    selected = selected,
                                    onClick = { },
                                    role = Role.Checkbox
                                ),
                            colors = if (selected)
                                        ChipDefaults.chipColors(
                                            backgroundColor = Color.Black,
                                            contentColor = Color.White)
                                    else ChipDefaults.chipColors(
                                backgroundColor = Color.LightGray,
                                contentColor = contentColorFor(backgroundColor = Color.LightGray)),
                            onClick = {
                                trigger.selected = !trigger.selected
                                selected = trigger.selected
                                Log.i("${trigger.title} is selected: ${trigger.selected}", "selected check")
                            }
                        ) {
                            Text(trigger.title)
                        }
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun getConditionLogState(feeling: ConditionLog.Feeling): ConditionLog {
    val triggers = triggerGroupListToTriggerList(triggerGroups)
    return ConditionLog(
        id = 0,
        date = LocalDateTime.now(),
        feeling = feeling,
        food_trigger_1 = if(triggers[0].selected) 1 else 0,
        food_trigger_2 = if(triggers[1].selected) 1 else 0,
        food_trigger_3 = if(triggers[2].selected) 1 else 0,
        food_trigger_4 = if(triggers[3].selected) 1 else 0,
        food_trigger_5 = if(triggers[4].selected) 1 else 0,
        food_trigger_6 = if(triggers[5].selected) 1 else 0,
        food_trigger_7 = if(triggers[6].selected) 1 else 0,
        food_trigger_8 = if(triggers[7].selected) 1 else 0,
        food_trigger_9 = if(triggers[8].selected) 1 else 0,
        food_trigger_10 = if(triggers[9].selected) 1 else 0,
        weather_trigger_1 = if(triggers[10].selected) 1 else 0,
        weather_trigger_2 = if(triggers[11].selected) 1 else 0,
        weather_trigger_3 = if(triggers[12].selected) 1 else 0,
        weather_trigger_4 = if(triggers[13].selected) 1 else 0,
        weather_trigger_5 = if(triggers[14].selected) 1 else 0,
        weather_trigger_6 = if(triggers[15].selected) 1 else 0,
        weather_trigger_7 = if(triggers[16].selected) 1 else 0,
        weather_trigger_8 = if(triggers[17].selected) 1 else 0,
        mental_health_trigger_1 = if(triggers[18].selected) 1 else 0,
        mental_health_trigger_2 = if(triggers[19].selected) 1 else 0,
        mental_health_trigger_3 = if(triggers[20].selected) 1 else 0,
        other_trigger_1 = if(triggers[21].selected) 1 else 0,
        other_trigger_2 = if(triggers[22].selected) 1 else 0,
        other_trigger_3 = if(triggers[23].selected) 1 else 0,
        other_trigger_4 = if(triggers[24].selected) 1 else 0
    )
}

fun triggerGroupListToTriggerList(triggerGroups: List<TriggerGroup>): List<Trigger>  {
    val triggers = mutableListOf<Trigger>()
    triggerGroups.forEach { triggerGroup ->  
        triggerGroup.triggers.forEach { trigger ->
            triggers.add(trigger)
        }
    }
    return triggers;
}

fun sliderPositionToFeeling(sliderPosition: Float): ConditionLog.Feeling = when (sliderPosition.toInt()) {
        0 -> { ConditionLog.Feeling.feeling_1 }
        1 -> { ConditionLog.Feeling.feeling_2 }
        2 -> { ConditionLog.Feeling.feeling_3 }
        3 -> { ConditionLog.Feeling.feeling_4 }
        4 -> { ConditionLog.Feeling.feeling_5 }
        else -> { ConditionLog.Feeling.feeling_1 }
}