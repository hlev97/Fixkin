package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history.content

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ListContent(
    allConditionLogs: List<ConditionLog>,
    onClick: (id: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(allConditionLogs) { log ->
            ListItem(
                log = log,
                onClick = { id ->
                    onClick(id)
                }
            )
        }
    }
}