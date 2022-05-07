package hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.component

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.check_condition_log.CheckConditionLogViewModel
import hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.check_condition_log.util.TriggerGroup
import hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.util.feelings
import hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.util.sliderPositionToFeeling
import hu.bme.aut.it9p0z.fixkin.ui.theme.chipColorSelected
import hu.bme.aut.it9p0z.fixkin.ui.theme.chipColorUnselected


@ExperimentalMaterialApi
@Composable
fun ConditionLogView(
    enabled: Boolean,
    position: Float,
    triggerGroups: List<TriggerGroup>?,
    onClick: () -> Unit,
    checkConditionLogViewModel: CheckConditionLogViewModel
) {
    if (triggerGroups != null) {
        var sliderPosition by remember { mutableStateOf(position) }
        Text(text = "Feeling")
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..4f,
            onValueChangeFinished = {
                checkConditionLogViewModel.sliderPosition = sliderPosition
                checkConditionLogViewModel.feelingValue = sliderPositionToFeeling(sliderPosition)
            },
            steps = 3,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colors.secondary,
                activeTrackColor = MaterialTheme.colors.secondary
            ),
            enabled = enabled
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
        TriggerGroupView(
            enabled = enabled,
            onClick = { onClick() },
            triggerGroups = triggerGroups
        )
    }
}

@Composable
@ExperimentalMaterialApi
fun TriggerGroupView(
    enabled: Boolean,
    onClick: () -> Unit,
    triggerGroups: List<TriggerGroup>?
) {
    triggerGroups?.forEach { triggerGroup ->
        Text(text = triggerGroup.title)
        FlowRow(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 15.dp)) {
            triggerGroup.triggers.forEach { trigger ->
                var selected by remember { mutableStateOf(trigger.selected) }
                Chip(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .selectable(
                            enabled = enabled,
                            selected = selected,
                            onClick = { },
                            role = Role.Checkbox
                        ),
                    enabled = enabled,
                    colors = if (selected)
                        ChipDefaults.chipColors(
                            backgroundColor = MaterialTheme.colors.chipColorSelected,
                            contentColor = MaterialTheme.colors.contentColorFor( MaterialTheme.colors.chipColorSelected))
                    else ChipDefaults.chipColors(
                        backgroundColor = MaterialTheme.colors.chipColorUnselected,
                        contentColor = contentColorFor(MaterialTheme.colors.chipColorUnselected)
                    ),
                    onClick = {
                        trigger.selected = !trigger.selected
                        selected = trigger.selected
                        onClick()
                    }
                ) {
                    Text(trigger.title)
                }
            }
        }
    }
}