package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import hu.bme.aut.it9p0z.fixkin.ui.theme.FixkinTheme
import kotlinx.coroutines.launch

@Composable
fun MainTopAppBar(
    modifier: Modifier,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TopAppBar(
            modifier = modifier,
            title = {
                Text(text = "Fixkin")
            }
        )
    }
}

@Preview
@Composable
fun TopBarPreview() {
    FixkinTheme {
        MainTopAppBar(modifier = Modifier)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun TopBaDarkPreview() {
    FixkinTheme {
        MainTopAppBar(modifier = Modifier)
    }
}