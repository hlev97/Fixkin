package hu.bme.aut.it9p0z.fixkin.data.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import hu.bme.aut.it9p0z.fixkin.util.PersistenceConstants
import java.time.LocalDateTime

@Entity(tableName = "condition_logs")
data class ConditionLog(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "date") val date: LocalDateTime,
    @ColumnInfo(name = "feeling") val feeling: Feeling,

    @ColumnInfo(name = PersistenceConstants.food_trigger_1) val food_trigger_1: Int,
    @ColumnInfo(name = PersistenceConstants.food_trigger_2) val food_trigger_2: Int,
    @ColumnInfo(name = PersistenceConstants.food_trigger_3) val food_trigger_3: Int,
    @ColumnInfo(name = PersistenceConstants.food_trigger_4) val food_trigger_4: Int,
    @ColumnInfo(name = PersistenceConstants.food_trigger_5) val food_trigger_5: Int,
    @ColumnInfo(name = PersistenceConstants.food_trigger_6) val food_trigger_6: Int,
    @ColumnInfo(name = PersistenceConstants.food_trigger_7) val food_trigger_7: Int,
    @ColumnInfo(name = PersistenceConstants.food_trigger_8) val food_trigger_8: Int,
    @ColumnInfo(name = PersistenceConstants.food_trigger_9) val food_trigger_9: Int,
    @ColumnInfo(name = PersistenceConstants.food_trigger_10) val food_trigger_10: Int,

    @ColumnInfo(name = PersistenceConstants.weather_trigger_1) val weather_trigger_1: Int,
    @ColumnInfo(name = PersistenceConstants.weather_trigger_2) val weather_trigger_2: Int,
    @ColumnInfo(name = PersistenceConstants.weather_trigger_3) val weather_trigger_3: Int,
    @ColumnInfo(name = PersistenceConstants.weather_trigger_4) val weather_trigger_4: Int,
    @ColumnInfo(name = PersistenceConstants.weather_trigger_5) val weather_trigger_5: Int,
    @ColumnInfo(name = PersistenceConstants.weather_trigger_6) val weather_trigger_6: Int,
    @ColumnInfo(name = PersistenceConstants.weather_trigger_7) val weather_trigger_7: Int,
    @ColumnInfo(name = PersistenceConstants.weather_trigger_8) val weather_trigger_8: Int,

    @ColumnInfo(name = PersistenceConstants.mental_health_trigger_1) val mental_health_trigger_1: Int,
    @ColumnInfo(name = PersistenceConstants.mental_health_trigger_2) val mental_health_trigger_2: Int,
    @ColumnInfo(name = PersistenceConstants.mental_health_trigger_3) val mental_health_trigger_3: Int,

    @ColumnInfo(name = PersistenceConstants.other_trigger_1) val other_trigger_1: Int,
    @ColumnInfo(name = PersistenceConstants.other_trigger_2) val other_trigger_2: Int,
    @ColumnInfo(name = PersistenceConstants.other_trigger_3) val other_trigger_3: Int,
    @ColumnInfo(name = PersistenceConstants.other_trigger_4) val other_trigger_4: Int
) {
    enum class Feeling(val text: String) {
        feeling_1("sad"),
        feeling_2("unhappy"),
        feeling_3("neutral"),
        feeling_4("happy"),
        feeling_5("joyful");

        companion object {
            @JvmStatic
            @TypeConverter
            fun getByOrdinal(ordinal: Int): Feeling? {
                var ret: Feeling? = null
                for (feeling in values()) {
                    if (feeling.ordinal == ordinal) {
                        ret = feeling
                        break
                    }
                }
                return ret
            }

            @JvmStatic
            @TypeConverter
            fun toInt(feeling: Feeling): Int {
                return feeling.ordinal
            }
        }
    }
}
