package hu.bme.aut.it9p0z.fixkin.presentation.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences")

class DataStoreRepository(context: Context) {
    private object PreferenceKeys {
        val onFirstOpening = booleanPreferencesKey(name = "on_first_opening")
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
}