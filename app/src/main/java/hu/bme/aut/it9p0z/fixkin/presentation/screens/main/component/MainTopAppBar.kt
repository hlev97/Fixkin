package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

@Composable
fun MainTopAppBar(
    modifier: Modifier,
    openSideBar: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        navigationIcon = {
            IconButton(
                onClick = { openSideBar() }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "menu"
                )
            }
        },
        title = {
            Text(text = "Fixkin")
        }
    )
}