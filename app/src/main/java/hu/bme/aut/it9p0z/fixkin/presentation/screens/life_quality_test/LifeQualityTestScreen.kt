package hu.bme.aut.it9p0z.fixkin.presentation.screens.life_quality_test

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import hu.bme.aut.it9p0z.fixkin.presentation.screens.life_quality_test.util.TestQuestion


@Composable
fun LifeQualityTestScreen(
//    navController: NavHostController,
//    lifeQualityTestViewModel: LifeQualityTestViewModel
) {
    val questions = listOf(
        TestQuestion.Qs1,
        TestQuestion.Qs2,
        TestQuestion.Qs3,
        TestQuestion.Qs4,
        TestQuestion.Qs5,
        TestQuestion.Qs6,
        TestQuestion.Qs7a,
        TestQuestion.Qs7b,
        TestQuestion.Qs8,
        TestQuestion.Qs9,
        TestQuestion.Qs10
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                items = questions,
                itemContent = { TestQuestion(qs = it)}
            )

            item {
                Button(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Save",
                        style = MaterialTheme.typography.button
                    )
                }
            }
        }
    }
}



@Composable
fun TestQuestion(qs: TestQuestion) {
    val answers = qs.answers
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(answers[0]) }
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(bottom = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .selectableGroup()
        ) {
            Text(
                text =  qs.text,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Start
            )
            answers.forEach { answer ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = (answer == selectedOption),
                            onClick = { onOptionSelected(answer)},
                            role = Role.RadioButton
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (answer == selectedOption),
                        onClick = {  onOptionSelected(answer) }
                    )
                    Text(
                        text = answer.text,
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TestQuestionPreview() {
    LifeQualityTestScreen()
}



