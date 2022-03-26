package hu.bme.aut.it9p0z.fixkin.presentation.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.data.repository.ConditionLogRepository
import hu.bme.aut.it9p0z.fixkin.data.repository.Repository
import hu.bme.aut.it9p0z.fixkin.presentation.data.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    fun getLastLog(): LiveData<ConditionLog> = repository.getLastConditionLog()

    fun readDailyConditionLogCounterValue(): Flow<Int> = repository.readDailyConditionLogCounterValue()

    suspend fun initDailyConditionLogCounter() { repository.initDailyConditionLogCounter() }
}