package hu.bme.aut.it9p0z.fixkin.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import hu.bme.aut.it9p0z.fixkin.data.dao.ConditionLogDao
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import kotlinx.coroutines.flow.Flow

class ConditionLogRepository(
    private val dao: ConditionLogDao
) {
    fun getAllLogs(): Flow<List<ConditionLog>> = dao.getLogs()

    fun getLog(id: Int): Flow<ConditionLog> = dao.getLog(id)

    fun getLastLog(): LiveData<ConditionLog> = dao.getLastLog().asLiveData()

    suspend fun insert(log: ConditionLog) { dao.insertLog(log) }

    suspend fun update(log: ConditionLog) { dao.updateLog(log) }

    suspend fun delete(log: ConditionLog) { dao.deleteLog(log) }
}