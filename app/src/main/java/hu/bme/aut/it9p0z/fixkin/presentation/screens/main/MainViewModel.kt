package hu.bme.aut.it9p0z.fixkin.presentation.screens.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.data.model.LifeQualityTestResultLog
import hu.bme.aut.it9p0z.fixkin.data.repository.Repository
import hu.bme.aut.it9p0z.fixkin.util.conditionMockLogs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    fun getLastLog(): LiveData<ConditionLog> = repository.getLastConditionLog()

    fun readDailyConditionLogCounterValue(): Flow<Int> = repository.readDailyConditionLogCounterValue()

    suspend fun initDailyConditionLogCounter() { repository.initDailyConditionLogCounter() }

    private fun getAllConditionLog(): Flow<List<ConditionLog>> = repository.getAllConditionLog()

    private fun getAllLifeQualityTestResultLog(): Flow<List<LifeQualityTestResultLog>> = repository.getAllTestResult()

    fun deleteConditionLog(log: ConditionLog) {
        viewModelScope.launch {
            repository.deleteConditionLog(log)
        }
    }

    private val _allConditionLogs = MutableStateFlow<List<ConditionLog>>(listOf())
    val allConditionLogs = _allConditionLogs

    private val _allLifeQualityTestResultLogs = MutableStateFlow<List<LifeQualityTestResultLog>>(listOf())
    val allLifeQualityTestResultLogs = _allLifeQualityTestResultLogs

    init {
        viewModelScope.launch {
            getAllConditionLog().collect { logs ->
                _allConditionLogs.value = logs
            }
        }
        viewModelScope.launch {
            getAllLifeQualityTestResultLog().collect { logs ->
                _allLifeQualityTestResultLogs.value = logs
            }
        }

    }
}