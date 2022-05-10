package hu.bme.aut.it9p0z.fixkin.presentation.screens.life_quality_test.data

import hu.bme.aut.it9p0z.fixkin.data.model.LifeQualityTestResultLog.Answer
import hu.bme.aut.it9p0z.fixkin.util.TestQuestions

sealed class TestQuestion(
    val stringResourceId: Int,
    val answers: List<Answer>,
    var answer: Answer? = null
) {
    object Qs1 : TestQuestion(
        stringResourceId = TestQuestions.lqt_question_1,
        answers = listOf(Answer.answer_1, Answer.answer_2, Answer.answer_3, Answer.answer_4)
    )

    object Qs2 : TestQuestion(
        stringResourceId = TestQuestions.lqt_question_2,
        answers = listOf(Answer.answer_1, Answer.answer_2, Answer.answer_3, Answer.answer_4)
    )

    object Qs3 : TestQuestion(
        stringResourceId = TestQuestions.lqt_question_3,
        answers = listOf(Answer.answer_1, Answer.answer_2, Answer.answer_3, Answer.answer_4, Answer.answer_5)
    )

    object Qs4 : TestQuestion(
        stringResourceId = TestQuestions.lqt_question_1,
        answers = listOf(Answer.answer_1, Answer.answer_2, Answer.answer_3, Answer.answer_4, Answer.answer_5)
    )

    object Qs5 : TestQuestion(
        stringResourceId = TestQuestions.lqt_question_5,
        answers = listOf(Answer.answer_1, Answer.answer_2, Answer.answer_3, Answer.answer_4, Answer.answer_5)
    )

    object Qs6 : TestQuestion(
        stringResourceId = TestQuestions.lqt_question_1,
        answers = listOf(Answer.answer_1, Answer.answer_2, Answer.answer_3, Answer.answer_4, Answer.answer_5)
    )

    object Qs7a : TestQuestion(
        stringResourceId = TestQuestions.lqt_question_7a,
        answers = listOf(Answer.answer_6, Answer.answer_7, Answer.answer_5)
    )

    object Qs7b : TestQuestion(
        stringResourceId = TestQuestions.lqt_question_7b,
        answers = listOf(Answer.answer_2, Answer.answer_3, Answer.answer_4)
    )

    object Qs8 : TestQuestion(
        stringResourceId = TestQuestions.lqt_question_8,
        answers = listOf(Answer.answer_1, Answer.answer_2, Answer.answer_3, Answer.answer_4, Answer.answer_5)
    )

    object Qs9 : TestQuestion(
        stringResourceId = TestQuestions.lqt_question_1,
        answers = listOf(Answer.answer_1, Answer.answer_2, Answer.answer_3, Answer.answer_4, Answer.answer_5)
    )

    object Qs10 : TestQuestion(
        stringResourceId = TestQuestions.lqt_question_1,
        answers = listOf(Answer.answer_1, Answer.answer_2, Answer.answer_3, Answer.answer_4, Answer.answer_5)
    )
}
