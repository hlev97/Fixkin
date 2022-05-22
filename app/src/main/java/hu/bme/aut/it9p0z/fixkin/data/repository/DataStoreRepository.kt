package hu.bme.aut.it9p0z.fixkin.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


interface DataStoreRepository {
    suspend fun saveOnOpeningState(completed: Boolean)

    fun readOnOpeningState(): Flow<Boolean>

    suspend fun incrementDailyConditionLogCounter()

    suspend fun decrementDailyConditionLogCounter()

    fun readDailyConditionLogCounterValue(): Flow<Int>

    suspend fun initDailyConditionLogCounter()

    suspend fun saveOnWeeklyLifeQualityTestFilling(completed: Boolean)

    fun readOnWeeklyLifeQualityTestFillingState(): Flow<Boolean>

}