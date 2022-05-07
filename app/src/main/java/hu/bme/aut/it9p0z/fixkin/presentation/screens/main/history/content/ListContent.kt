package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history.content

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.semantics.CustomAccessibilityAction
import androidx.compose.ui.semantics.customActions
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog

@ExperimentalMaterialApi
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ListContent(
    modifier: Modifier = Modifier,
    allConditionLogs: List<ConditionLog>,
    onClick: (id: Int) -> Unit,
    onDelete: (log: ConditionLog) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(allConditionLogs, key = {item -> item.id}) { log ->
            var isLogItemDismissed by remember {
                mutableStateOf(false)
            }
            val dismissState = rememberDismissState(
                confirmStateChange = {
                    if (it == DismissValue.DismissedToEnd) {
                        isLogItemDismissed = true
                    }
                    true
                }
            )

            val logHeightAnimation by animateDpAsState(
                targetValue = if (isLogItemDismissed) 0.dp else 120.dp,
                animationSpec = tween(delayMillis = 300),
                finishedListener = {
                    onDelete(log)
                }
            )
            val deleteLogLabel = "delete"
            SwipeToDismiss(
                modifier = Modifier.semantics {
                    customActions = listOf(
                        CustomAccessibilityAction(deleteLogLabel) {
                            onDelete(log)
                            true
                        }
                    )
                },
                directions = setOf(
                    DismissDirection.StartToEnd
                ),
                dismissThresholds = {
                    FractionalThreshold(0.15f)
                },
                background = {
                    ListItemBackground(
                        modifier = Modifier
                            .height(logHeightAnimation)
                            .fillMaxWidth(),
                        targetValue = dismissState.targetValue,
                        currentValue = dismissState.currentValue
                    )
                },
                state = dismissState,
                dismissContent = {
                    ListItem(
                        modifier = Modifier
                            .height(logHeightAnimation)
                            .fillMaxWidth(),
                        log = log,
                        onClick = { id ->
                            onClick(id)
                        },
                        dismissDirection = dismissState.dismissDirection
                    )
                }
            )
            val dividerVisibilityAnimation by animateFloatAsState(
                targetValue = if (dismissState.targetValue == DismissValue.Default) {
                    1f
                } else 0f,
                animationSpec = tween(delayMillis = 300)
            )
            Divider(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .alpha(dividerVisibilityAnimation)
            )
        }
    }
}