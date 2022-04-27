package hu.bme.aut.it9p0z.fixkin.presentation.screens.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.data.repository.ConditionLogRepository
import hu.bme.aut.it9p0z.fixkin.data.repository.Repository
import hu.bme.aut.it9p0z.fixkin.presentation.data.repository.DataStoreRepository
import hu.bme.aut.it9p0z.fixkin.presentation.screens.main.history.util.HistoryState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
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

    private val _allConditionLogs = MutableStateFlow<List<ConditionLog>>(listOf())
    val allConditionLogs = _allConditionLogs

    init {
        viewModelScope.launch {
            getAllConditionLog().collect { logs ->
                _allConditionLogs.value = logs
            }
        }
    }
}