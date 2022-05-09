package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history.content

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hu.bme.aut.it9p0z.fixkin.R
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.ui.theme.FixkinTheme
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ListItem(
    modifier: Modifier,
    log: ConditionLog,
    onClick: (conditionLogId: Int) -> Unit,
    dismissDirection: DismissDirection?
) {
    val listItemElevation by animateDpAsState(
        targetValue = if (dismissDirection != null) {
            4.dp
        } else 0.dp
    )
    val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm")
    Surface(
        modifier = modifier
            .clickable { onClick(log.id) },
        elevation = listItemElevation
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 15.dp),
                text = log.date.format(formatter)
            )
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 15.dp),
                painter = painterResource(id = feelingToIcon(log.feeling)),
                contentDescription = "feeling"
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun ListItemBackground(
    modifier: Modifier,
    targetValue: DismissValue,
    currentValue: DismissValue
) {
    val backgroundColor by animateColorAsState(
        targetValue = when (targetValue) {
            DismissValue.DismissedToEnd -> MaterialTheme.colors.error
            else -> MaterialTheme.colors.background
        },
        animationSpec = tween()
    )
    val iconColor by animateColorAsState(
        targetValue = when (targetValue) {
            DismissValue.DismissedToEnd -> MaterialTheme.colors.onError
            else -> MaterialTheme.colors.onSurface
        },
        animationSpec = tween()
    )
    val scale by animateFloatAsState(
        targetValue = if (targetValue == DismissValue.DismissedToEnd) {
            1f
        } else 0.75f
    )
    Box(
        modifier = modifier
            .background(backgroundColor)
            .padding(horizontal = 20.dp)
    ) {
        if (currentValue == DismissValue.Default) {
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .scale(scale),
                imageVector = Icons.Default.Delete,
                tint = iconColor,
                contentDescription = "Delete Log"
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ListItemPreview() {
    FixkinTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
                .clip(RoundedCornerShape(25.dp))
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 15.dp),
                text = "2012. 08. 13"
            )
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 15.dp),
                painter = painterResource(id = R.drawable.ic_sentiment_very_satisfied_black_24dp),
                contentDescription = "feeling"
            )
        }
    }
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun ListItemDarkPreview() {
    FixkinTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
                .clip(RoundedCornerShape(25.dp))
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 15.dp),
                text = "2012. 08. 13"
            )
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 15.dp),
                painter = painterResource(id = R.drawable.ic_sentiment_very_satisfied_black_24dp),
                contentDescription = "feeling"
            )
        }
    }
}

fun feelingToIcon(feeling: ConditionLog.Feeling): Int = when(feeling) {
    ConditionLog.Feeling.feeling_1 -> R.drawable.ic_sentiment_very_dissatisfied_black_24dp
    ConditionLog.Feeling.feeling_2 -> R.drawable.ic_sentiment_dissatisfied_black_24dp
    ConditionLog.Feeling.feeling_3 -> R.drawable.ic_sentiment_neutral_black_24dp
    ConditionLog.Feeling.feeling_4 -> R.drawable.ic_sentiment_satisfied_black_24dp
    ConditionLog.Feeling.feeling_5 -> R.drawable.ic_sentiment_very_satisfied_black_24dp
}