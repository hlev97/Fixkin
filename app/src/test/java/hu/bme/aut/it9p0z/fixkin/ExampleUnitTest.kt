package hu.bme.aut.it9p0z.fixkin

import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDateTime

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    
    @Test
    fun addConditionLog_isCorrect() {
        val conditionLog = ConditionLog(
            id = 0,
            date = LocalDateTime.now(),
            feeling = ConditionLog.Feeling.feeling_5,
            food_trigger_1 = 0,
            food_trigger_2 = 1,
            food_trigger_3 = 0,
            food_trigger_4 = 1,
            food_trigger_5 = 1,
            food_trigger_6 = 0,
            food_trigger_7 = 1,
            food_trigger_8 = 0,
            food_trigger_9 = 1,
            food_trigger_10 = 0,
            weather_trigger_1 = 1,
            weather_trigger_2 = 0,
            weather_trigger_3 = 1,
            weather_trigger_4 = 0,
            weather_trigger_5 = 1,
            weather_trigger_6 = 0,
            weather_trigger_7 = 1,
            weather_trigger_8 = 0,
            mental_health_trigger_1 = 1,
            mental_health_trigger_2 = 0,
            mental_health_trigger_3 = 1,
            other_trigger_1 = 1,
            other_trigger_2 = 0,
            other_trigger_3 = 1,
            other_trigger_4 = 0
        )


    }
}