package hu.bme.aut.it9p0z.fixkin.presentation.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences")

class DataStoreRepository(context: Context) {
    private object PreferenceKeys {
        val onFirstOpening = booleanPreferencesKey(name = "on_first_opening")
        val dailyConditionLogCounter = intPreferencesKey(name = "on_daily_condition_log_counter")
        val onWeeklyLifeQualityTestFilling = booleanPreferencesKey(name = "on_weekly_life_quality_test_filling")
    }

    private val dataStore = context.dataStore

    suspend fun saveOnOpeningState(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.onFirstOpening] = completed
        }
    }

    fun readOnOpeningState(): Flow<Boolean> {
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

    suspend fun incrementDailyConditionLogCounter() {
        dataStore.edit { preferences ->
            val currentCounterValue = preferences[PreferenceKeys.dailyConditionLogCounter] ?: 0
            preferences[PreferenceKeys.dailyConditionLogCounter] = currentCounterValue + 1
        }
    }

    fun readDailyConditionLogCounterValue(): Flow<Int> {
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

    suspend fun initDailyConditionLogCounter() {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.dailyConditionLogCounter] = 0
        }
    }

    suspend fun saveOnWeeklyLifeQualityTestFilling(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.onWeeklyLifeQualityTestFilling] = completed
        }
    }

    fun readOnWeeklyLifeQualityTestFillingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val onWeeklyLifeQualityTestFillingState = preferences[PreferenceKeys.onWeeklyLifeQualityTestFilling] ?: false
                onWeeklyLifeQualityTestFillingState
            }
    }
}