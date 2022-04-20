package hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.check_condition_log

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CheckConditionBar(
    selectedConditionLog: ConditionLog?,
    navigateBack: () -> Unit,
    setEditable: () -> Unit,
    onDelete: () -> Unit,
    enabled: Boolean
) {
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = { navigateBack() }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back"
                )
            }
        },
        title = {
            val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm")
            Text(text = selectedConditionLog?.date?.format(formatter) ?: "")
        },
        actions = {
            if (enabled) {
                IconButton(
                    onClick = { setEditable() }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "done"
                    )
                }
            } else {
                IconButton(onClick = { onDelete() }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "delete" )
                }
                IconButton(
                    onClick = { setEditable() }
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "done"
                    )
                }
            }
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun BarPreview() {

    CheckConditionBar(
        selectedConditionLog = null,
        navigateBack = {},
        setEditable = {},
        onDelete = {},
        enabled = true
    )
}