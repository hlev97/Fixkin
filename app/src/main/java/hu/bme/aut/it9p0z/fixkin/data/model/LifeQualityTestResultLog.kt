package hu.bme.aut.it9p0z.fixkin.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants

@Entity(tableName = "test_results")
data class LifeQualityTestResultLog(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = PersistenceConstants.lqt_date) val lqt_date: String,
    @ColumnInfo(name = PersistenceConstants.lqt_score) val lqt_score: String,
    @ColumnInfo(name = PersistenceConstants.lqt_evaluation) val lqt_evaluation: Evaluation,

    @ColumnInfo(name = "qs1") val question_1: Answer,
    @ColumnInfo(name = "qs2") val question_2: Answer,
    @ColumnInfo(name = "qs3") val question_3: Answer,
    @ColumnInfo(name = "qs4") val question_4: Answer,
    @ColumnInfo(name = "qs5") val question_5: Answer,
    @ColumnInfo(name = "qs6") val question_6: Answer,
    @ColumnInfo(name = "qs7a") val question_7a: Answer,
    @ColumnInfo(name = "qs7b") val question_7b: Answer,
    @ColumnInfo(name = "qs8") val question_8: Answer,
    @ColumnInfo(name = "qs9") val question_9: Answer,
    @ColumnInfo(name = "qs10") val question_10: Answer,
) {
    enum class Evaluation(val text: String) {
        eval_1("no effect at all"),
        eval_2("small effect"),
        eval_3("moderate effect"),
        eval_4("very large effect"),
        eval_5("extremely large effect");

        companion object {
            @JvmStatic
            @TypeConverter
            fun getByOrdinal(ordinal: Int): Evaluation? {
                var ret: Evaluation? = null
                for (eval in values()) {
                    if (eval.ordinal == ordinal) {
                        ret = eval
                        break
                    }
                }
                return ret
            }

            @JvmStatic
            @TypeConverter
            fun toInt(eval: Evaluation): Int {
                return eval.ordinal
            }
        }
    }

    enum class Answer(val text: String, val point: Int) {
        answer_1("Very much", 3),
        answer_2("A lot", 2),
        answer_3("A little", 1),
        answer_4("Not at all", 0),
        answer_5("Not relevant", 0),
        answer_6("Yes", 3),
        answer_7("No", 0);

        companion object {
            @JvmStatic
            @TypeConverter
            fun getByOrdinal(ordinal: Int): Answer? {
                var ret: Answer? = null
                for (answer in values()) {
                    if (answer.ordinal == ordinal) {
                        ret = answer
                        break
                    }
                }
                return ret
            }

            @JvmStatic
            @TypeConverter
            fun toInt(answer: Answer): Int {
                return answer.ordinal
            }
        }
    }
}
