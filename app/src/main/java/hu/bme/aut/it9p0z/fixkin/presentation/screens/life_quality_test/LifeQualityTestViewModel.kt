package hu.bme.aut.it9p0z.fixkin.presentation.screens.life_quality_test

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.it9p0z.fixkin.data.model.LifeQualityTestResultLog
import hu.bme.aut.it9p0z.fixkin.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class LifeQualityTestViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    suspend fun saveTestResult(result: LifeQualityTestResultLog) { repository.insertTestResult(result) }

    suspend fun saveOnWeeklyLifeQualityTestFilling(completed: Boolean) { repository.saveOnWeeklyLifeQualityTestFilling(completed) }

    fun readOnWeeklyLifeQualityTestFillingState(): Flow<Boolean> = repository.readOnWeeklyLifeQualityTestFillingState()
}