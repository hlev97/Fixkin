package hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.check_condition_log

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import hu.bme.aut.it9p0z.fixkin.R
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.ui.theme.FixkinTheme
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
                    contentDescription = stringResource(id = R.string.back_button)
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
                        contentDescription = stringResource(R.string.close_btn)
                    )
                }
            } else {
                IconButton(onClick = { onDelete() }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = stringResource(R.string.deleten_btn) )
                }
                IconButton(
                    onClick = { setEditable() }
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = stringResource(R.string.edit_btn)
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
    FixkinTheme() {
        CheckConditionBar(
            selectedConditionLog = null,
            navigateBack = {},
            setEditable = {},
            onDelete = {},
            enabled = true
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun BarDarkPreview() {
    FixkinTheme() {
        CheckConditionBar(
            selectedConditionLog = null,
            navigateBack = {},
            setEditable = {},
            onDelete = {},
            enabled = true
        )
    }
}