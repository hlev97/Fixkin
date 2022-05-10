package hu.bme.aut.it9p0z.fixkin.presentation.viewmodels.main

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.data.model.LifeQualityTestResultLog
import hu.bme.aut.it9p0z.fixkin.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    fun getLastConditionLog(): Flow<ConditionLog> = repository.getLastConditionLog()

    private fun readDailyConditionLogCounterValue(): Flow<Int> = repository.readDailyConditionLogCounterValue()

    fun initDailyConditionLogCounter() {
        viewModelScope.launch {
            repository.initDailyConditionLogCounter()
        }
    }

    private fun getAllConditionLog(): Flow<List<ConditionLog>> = repository.getAllConditionLogs()

    private fun getAllLifeQualityTestResultLog(): Flow<List<LifeQualityTestResultLog>> = repository.getAllLqtrLogs()

    fun deleteConditionLog(log: ConditionLog) {
        viewModelScope.launch {
            repository.deleteConditionLog(log)
        }
    }

    private val _allConditionLogs = MutableStateFlow<List<ConditionLog>>(listOf())
    val allConditionLogs = _allConditionLogs

    private val _allLifeQualityTestResultLogs = MutableStateFlow<List<LifeQualityTestResultLog>>(listOf())
    val allLifeQualityTestResultLogs = _allLifeQualityTestResultLogs

    private var _dailyConditionLogCounter = MutableStateFlow(0)
    val dailyConditionLogCounter = _dailyConditionLogCounter

    init {
        viewModelScope.launch {
            getAllConditionLog().collect { logs ->
                _allConditionLogs.value = logs
            }
        }
        viewModelScope.launch {
            getAllLifeQualityTestResultLog().collect { logs ->
                _allLifeQualityTestResultLogs.value = logs
                Log.i("size: ${logs.size}", "lqti")
            }
        }
        viewModelScope.launch {
            readDailyConditionLogCounterValue().collect { cnt ->
                _dailyConditionLogCounter.value = _dailyConditionLogCounter.value + cnt
            }
        }
    }
}