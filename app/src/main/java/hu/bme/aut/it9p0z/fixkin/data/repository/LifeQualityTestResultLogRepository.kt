package hu.bme.aut.it9p0z.fixkin.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import hu.bme.aut.it9p0z.fixkin.data.dao.LifeQualityTestResultLogDao
import hu.bme.aut.it9p0z.fixkin.data.model.LifeQualityTestResultLog
import kotlinx.coroutines.flow.Flow

interface LifeQualityTestResultLogRepository {
    fun getAllLqtrLogs(): Flow<List<LifeQualityTestResultLog>>

    fun getLqtrLog(id: Int): Flow<LifeQualityTestResultLog>

    fun getLastLqtrLog(): Flow<LifeQualityTestResultLog>

    suspend fun insertLqtrLog(log: LifeQualityTestResultLog)

    suspend fun updateLqtrLog(log: LifeQualityTestResultLog)

    suspend fun deleteLqtrLog(log: LifeQualityTestResultLog)
}