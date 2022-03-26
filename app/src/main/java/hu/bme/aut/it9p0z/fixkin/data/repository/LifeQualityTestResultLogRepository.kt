package hu.bme.aut.it9p0z.fixkin.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import hu.bme.aut.it9p0z.fixkin.data.dao.LifeQualityTestResultLogDao
import hu.bme.aut.it9p0z.fixkin.data.model.LifeQualityTestResultLog

class LifeQualityTestResultLogRepository(
    private val dao: LifeQualityTestResultLogDao
) {
    fun getAllLogs(): LiveData<List<LifeQualityTestResultLog>> = dao.getLogs().asLiveData()

    fun getLog(id: Int): LiveData<LifeQualityTestResultLog> = dao.getLog(id).asLiveData()

    fun getLastLog(): LiveData<LifeQualityTestResultLog> = dao.getLastLog().asLiveData()

    suspend fun insert(log: LifeQualityTestResultLog) { dao.insertLog(log) }

    suspend fun update(log: LifeQualityTestResultLog) { dao.updateLog(log) }

    suspend fun delete(log: LifeQualityTestResultLog) { dao.deleteLog(log) }

}