package hu.bme.aut.it9p0z.fixkin.data.repository

import androidx.lifecycle.LiveData
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.data.model.LifeQualityTestResultLog
import hu.bme.aut.it9p0z.fixkin.presentation.data.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStoreRepo: DataStoreRepository,
    private val lqtResultLogRepo: LifeQualityTestResultLogRepository,
    private val conditionLogRepo: ConditionLogRepository
) {
    /**
     * Condition Logs operations
     */

    fun getAllConditionLog(): LiveData<List<ConditionLog>> = conditionLogRepo.getAllLogs()

    suspend fun insertConditionLog(log: ConditionLog) { conditionLogRepo.insert(log) }

    suspend fun updateConditionLog(log: ConditionLog) { conditionLogRepo.update(log) }

    suspend fun deleteConditionLog(log: ConditionLog) { conditionLogRepo.delete(log) }

    fun getConditionLog(id: Int): LiveData<ConditionLog> = conditionLogRepo.getLog(id)

    fun getLastConditionLog(): LiveData<ConditionLog> = conditionLogRepo.getLastLog()

    /**
     * Test Results Table operations
     */

    fun getAllTestResult(): LiveData<List<LifeQualityTestResultLog>> = lqtResultLogRepo.getAllLogs()

    suspend fun insertTestResult(result: LifeQualityTestResultLog) { lqtResultLogRepo.insert(result) }

    suspend fun updateTestResult(result: LifeQualityTestResultLog) { lqtResultLogRepo.update(result) }

    suspend fun deleteTestResult(result: LifeQualityTestResultLog) { lqtResultLogRepo.delete(result) }

    fun getTestResult(id: Int): LiveData<LifeQualityTestResultLog> = lqtResultLogRepo.getLog(id)

    fun getLastTestResult(): LiveData<LifeQualityTestResultLog> = lqtResultLogRepo.getLastLog()

    /**
     * Preferences operations
     */

    suspend fun saveOnOpeningState(completed: Boolean) { dataStoreRepo.saveOnOpeningState(completed) }

    fun readOnOpeningState(): Flow<Boolean> = dataStoreRepo.readOnOpeningState()

    suspend fun incrementDailyConditionLogCounter() { dataStoreRepo.incrementDailyConditionLogCounter() }

    fun readDailyConditionLogCounterValue(): Flow<Int> = dataStoreRepo.readDailyConditionLogCounterValue()

    suspend fun initDailyConditionLogCounter() { dataStoreRepo.initDailyConditionLogCounter() }

    suspend fun saveOnWeeklyLifeQualityTestFilling(completed: Boolean) { dataStoreRepo.saveOnWeeklyLifeQualityTestFilling(completed) }

    fun readOnWeeklyLifeQualityTestFillingState(): Flow<Boolean> = dataStoreRepo.readOnWeeklyLifeQualityTestFillingState()
}