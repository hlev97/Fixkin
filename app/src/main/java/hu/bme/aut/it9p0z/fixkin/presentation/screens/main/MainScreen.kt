package hu.bme.aut.it9p0z.fixkin.presentation.screens.main

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import hu.bme.aut.it9p0z.fixkin.R
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.navigation.Screen
import java.time.format.DateTimeFormatter

@SuppressLint("StateFlowValueCalledInComposition")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val allConditionLogs = mainViewModel.allConditionLogs.value

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        bottomBar = {

        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Text(text = "Add")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item{
                Text(
                    text = "This is the Main screen",
                    fontSize = 28.sp
                )
                Button(
                    onClick = { navController.navigate(Screen.AddConditionLog.screen_route) }
                ) {
                    Text(text = "Add Condition Log")
                }
                Button(onClick = { navController.navigate(Screen.LifeQualityTest.screen_route) }) {
                    Text(text = "DLQI TEST")
                }
            }

            items(allConditionLogs) { log ->
                ListItem(
                    log = log,
                    onClick = { id ->
                        navController.navigate(Screen.CheckConditionLog.passId(id))
                    }
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ListItem(
    log: ConditionLog,
    onClick: (conditionLogId: Int) -> Unit
) {
    val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm")
    Surface(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .clip(RoundedCornerShape(25.dp))
            .clickable { onClick(log.id) },
        elevation = 12.dp
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
    Box(
        Modifier
            .fillMaxWidth()
            .height(15.dp))
}

@Composable
@Preview(showBackground = true)
fun ListItemPreview() {
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

fun feelingToIcon(feeling: ConditionLog.Feeling): Int = when(feeling) {
    ConditionLog.Feeling.feeling_1 -> R.drawable.ic_sentiment_very_dissatisfied_black_24dp
    ConditionLog.Feeling.feeling_2 -> R.drawable.ic_sentiment_dissatisfied_black_24dp
    ConditionLog.Feeling.feeling_3 -> R.drawable.ic_sentiment_neutral_black_24dp
    ConditionLog.Feeling.feeling_4 -> R.drawable.ic_sentiment_satisfied_black_24dp
    ConditionLog.Feeling.feeling_5 -> R.drawable.ic_sentiment_very_satisfied_black_24dp
}