package hu.bme.aut.it9p0z.fixkin.presentation.screens.life_quality_test

import android.os.Build
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import hu.bme.aut.it9p0z.fixkin.data.model.LifeQualityTestResultLog
import hu.bme.aut.it9p0z.fixkin.navigation.Screen
import hu.bme.aut.it9p0z.fixkin.presentation.screens.life_quality_test.util.questions
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import hu.bme.aut.it9p0z.fixkin.data.model.LifeQualityTestResultLog.Result
import hu.bme.aut.it9p0z.fixkin.presentation.screens.life_quality_test.util.TestQuestion


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LifeQualityTestScreen(
    navController: NavHostController,
    lifeQualityTestViewModel: LifeQualityTestViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    val selectionStates = remember { mutableStateMapOf<Int, Int>()}

    BackHandler {
        navController.navigate(Screen.Main.screen_route)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        questions.forEachIndexed { i, question ->
            item {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .padding(bottom = 10.dp),
                    backgroundColor = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "${i+1}. " + question.text,
                            style = MaterialTheme.typography.subtitle1,
                            modifier = Modifier
                                .padding(10.dp),
                            color = MaterialTheme.colors.onBackground
                        )
                        Column(modifier = Modifier.fillMaxWidth().selectableGroup()) {
                            question.answers.forEachIndexed { j, answer ->
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .selectable(
                                        selected = (selectionStates[i] == j),
                                        onClick = {
                                            selectionStates[i] = j
                                            onSelected(i,j)
                                        },
                                        role = Role.RadioButton
                                    )
                                ) {
                                    RadioButton(
                                        selected = selectionStates[i] == j,
                                        onClick = null,
                                        modifier = Modifier.align(Alignment.CenterStart)
                                    )
                                    Text(
                                        text = answer.text,
                                        modifier = Modifier
                                            .align(Alignment.CenterStart)
                                            .padding(start = 50.dp),
                                        color = MaterialTheme.colors.onBackground
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        item {
            Button(
                onClick = {
                    if (!checkNull()) {
                        val score = countScore()
                        val result = giveResult(score)

                        val log = LifeQualityTestResultLog(
                            lqt_date = LocalDateTime.now(),
                            lqt_score = score,
                            lqt_result = result,
                            question_1 = questions[0].answer!!,
                            question_2 = questions[1].answer!!,
                            question_3 = questions[2].answer!!,
                            question_4 = questions[3].answer!!,
                            question_5 = questions[4].answer!!,
                            question_6 = questions[5].answer!!,
                            question_7a = questions[6].answer!!,
                            question_7b = questions[7].answer!!,
                            question_8 = questions[8].answer!!,
                            question_9 = questions[9].answer!!,
                            question_10 = questions[10].answer!!
                        )

                        scope.launch {
                            lifeQualityTestViewModel.saveTestResult(log)
                        }

                        navController.navigate(Screen.Main.screen_route)
                    }
                }
            ) {
                Text(
                    text= "Done",
                    fontSize = 18.sp
                )
            }
        }
    }
}

private fun countScore(): Int {
    var score = 0
    questions.forEachIndexed { i, testQuestion ->
        score += questions[i].answer?.point ?: 0
    }
    return score
}

fun giveResult(score: Int): Result {
    if (score < 2) return Result.result_1
    else if (score in 2..5) return Result.result_2
    else if (score in 6..10) return Result.result_3
    else if (score in 11..20) return Result.result_4
    return Result.result_5
}

private fun onSelected(i: Int, j: Int) {
    questions[i].answer = questions[i].answers[j]
}

private fun checkNull(): Boolean {
    questions.forEach { testQuestion ->
        if (testQuestion.answer == null) return true
    }
    return false
}





