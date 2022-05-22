package hu.bme.aut.it9p0z.fixkin.data.repository

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import hu.bme.aut.it9p0z.fixkin.data.dao.ConditionLogDao
import hu.bme.aut.it9p0z.fixkin.data.dao.LifeQualityTestResultLogDao
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.data.model.LifeQualityTestResultLog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences")
class Repository @Inject constructor(
    private val conditionLogDao: ConditionLogDao,
    private val lqtrLogDao: LifeQualityTestResultLogDao,
    private val  context: Context
) : ConditionLogRepository, LifeQualityTestResultLogRepository, DataStoreRepository {
    /**
     * Condition Logs operations
     */

   override fun getAllConditionLogs(): Flow<List<ConditionLog>> = conditionLogDao.getLogs()

    override suspend fun insertConditionLog(log: ConditionLog) { conditionLogDao.insertLog(log) }

    override suspend fun updateConditionLog(log: ConditionLog) { conditionLogDao.updateLog(log) }

    override suspend fun deleteConditionLog(log: ConditionLog) { conditionLogDao.deleteLog(log) }

    override fun getConditionLog(id: Int): Flow<ConditionLog> = conditionLogDao.getLog(id)

    override fun getLastConditionLog(): Flow<ConditionLog> = conditionLogDao.getLastLog()

    /**
     * Test Results Table operations
     */

    override fun getAllLqtrLogs(): Flow<List<LifeQualityTestResultLog>> = lqtrLogDao.getLogs()

    override fun getLqtrLog(id: Int): Flow<LifeQualityTestResultLog> = lqtrLogDao.getLog(id)

    override fun getLastLqtrLog(): Flow<LifeQualityTestResultLog> = lqtrLogDao.getLastLog()

    override suspend fun insertLqtrLog(log: LifeQualityTestResultLog) {
        lqtrLogDao.insertLog(log)
    }

    override suspend fun updateLqtrLog(log: LifeQualityTestResultLog) {
        lqtrLogDao.updateLog(log)
    }

    override suspend fun deleteLqtrLog(log: LifeQualityTestResultLog) {
       lqtrLogDao.deleteLog(log)
    }

    /**
     * Preferences operations
     */

    private object PreferenceKeys {
        val onFirstOpening = booleanPreferencesKey(name = "on_first_opening")
        val dailyConditionLogCounter = intPreferencesKey(name = "on_daily_condition_log_counter")
        val onWeeklyLifeQualityTestFilling = booleanPreferencesKey(name = "on_weekly_life_quality_test_filling")
    }

    private val dataStore = context.dataStore

    override suspend fun saveOnOpeningState(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.onFirstOpening] = completed
        }
    }

    override fun readOnOpeningState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val onFirstOpeningState = preferences[PreferenceKeys.onFirstOpening] ?: false
                onFirstOpeningState
            }
    }

    override suspend fun incrementDailyConditionLogCounter() {
        dataStore.edit { preferences ->
            val currentCounterValue = preferences[PreferenceKeys.dailyConditionLogCounter] ?: 0
            preferences[PreferenceKeys.dailyConditionLogCounter] = currentCounterValue + 1
        }
    }

    override fun readDailyConditionLogCounterValue(): Flow<Int> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                preferences[PreferenceKeys.dailyConditionLogCounter] ?: 0
            }
    }

    override suspend fun decrementDailyConditionLogCounter() {
        dataStore.edit { preferences ->
            val currentCounterValue = preferences[PreferenceKeys.dailyConditionLogCounter] ?: 0
            preferences[PreferenceKeys.dailyConditionLogCounter] = currentCounterValue - 1
        }
    }

    override suspend fun initDailyConditionLogCounter() {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.dailyConditionLogCounter] = 0
        }
    }

    override suspend fun saveOnWeeklyLifeQualityTestFilling(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.onWeeklyLifeQualityTestFilling] = completed
        }
    }

    override fun readOnWeeklyLifeQualityTestFillingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val onWeeklyLifeQualityTestFillingState =
                    preferences[PreferenceKeys.onWeeklyLifeQualityTestFilling] ?: false
                onWeeklyLifeQualityTestFillingState
            }
    }
}