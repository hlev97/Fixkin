package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.statistics.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import hu.bme.aut.it9p0z.fixkin.ui.theme.FixkinTheme

@Composable
fun EmptyContent(
    trigger: Boolean
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (trigger) Text(text = "You don't have enough logs about this trigger group.", textAlign = TextAlign.Center)
        else Text(text = "You haven't filled out enough DLQI surveys.", textAlign = TextAlign.Center)
    }
}

@Composable
@Preview(showBackground = true)
fun EmptyContentTriggerPreview() {
    FixkinTheme {
        EmptyContent(trigger = true)
    }
}

@Composable
@Preview(showBackground = true)
fun EmptyContentDlqiPreview() {
    FixkinTheme {
        EmptyContent(trigger = false)
    }
}