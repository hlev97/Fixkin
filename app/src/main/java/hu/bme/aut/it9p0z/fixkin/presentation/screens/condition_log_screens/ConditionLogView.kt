package hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import hu.bme.aut.it9p0z.fixkin.util.TriggerGroup
import hu.bme.aut.it9p0z.fixkin.util.triggerGroups
import hu.bme.aut.it9p0z.fixkin.ui.theme.FixkinTheme
import hu.bme.aut.it9p0z.fixkin.ui.theme.chipColorSelected
import hu.bme.aut.it9p0z.fixkin.ui.theme.chipColorUnselected
import hu.bme.aut.it9p0z.fixkin.util.feelings


@ExperimentalMaterialApi
@Composable
fun ConditionLogView(
    enabled: Boolean,
    position: Float,
    triggerGroups: List<TriggerGroup>?,
    onValueChanged: (pod: Float) -> Unit,
    onValueChangedFinished: () -> Unit,
) {
    if (triggerGroups != null) {
        Text(text = "Feeling")
        Slider(
            value = position,
            onValueChange = { pos ->
                onValueChanged(pos)
            },
            valueRange = 0f..4f,
            onValueChangeFinished = {
                onValueChangedFinished()
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
            triggerGroups = triggerGroups
        )
    }
}

@Composable
@ExperimentalMaterialApi
fun TriggerGroupView(
    enabled: Boolean,
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
                            contentColor = if(enabled) MaterialTheme.colors.contentColorFor( MaterialTheme.colors.chipColorSelected) else Color.LightGray)
                    else ChipDefaults.chipColors(
                        backgroundColor = MaterialTheme.colors.chipColorUnselected,
                        contentColor = contentColorFor(MaterialTheme.colors.chipColorUnselected)
                    ),
                    onClick = {
                        trigger.selected = !trigger.selected
                        selected = trigger.selected
                    }
                ) {
                    Text(stringResource(id = trigger.stringResourceId))
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun ConditionLogViewLightPreview() {
    FixkinTheme(darkTheme = false) {
        Column(Modifier.fillMaxWidth()) {
            ConditionLogView(
                enabled = true,
                position = 2f,
                triggerGroups = triggerGroups,
                onValueChanged = {},
                onValueChangedFinished = {}
            )
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES )
@Composable
fun ConditionLogViewDarkModePreview() {
    FixkinTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.background)) {
            ConditionLogView(
                enabled = true,
                position = 2f,
                triggerGroups = triggerGroups,
                onValueChanged = {},
                onValueChangedFinished = {}
            )
        }
    }
}