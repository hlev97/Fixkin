package hu.bme.aut.it9p0z.fixkin.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import hu.bme.aut.it9p0z.fixkin.data.dao.ConditionLogDao
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog

class ConditionLogRepository(
    private val dao: ConditionLogDao
) {
    fun getAllLogs(): LiveData<List<ConditionLog>> = dao.getLogs().asLiveData()

    fun getLog(id: Int): LiveData<ConditionLog> = dao.getLog(id).asLiveData()

    fun getLastLog(): LiveData<ConditionLog> = dao.getLastLog().asLiveData()

    suspend fun insert(log: ConditionLog) { dao.insertLog(log) }

    suspend fun update(log: ConditionLog) { dao.updateLog(log) }

    suspend fun delete(log: ConditionLog) { dao.deleteLog(log) }
}