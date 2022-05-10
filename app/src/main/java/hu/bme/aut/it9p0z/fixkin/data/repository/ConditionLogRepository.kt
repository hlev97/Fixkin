package hu.bme.aut.it9p0z.fixkin.data.repository

import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import kotlinx.coroutines.flow.Flow

interface ConditionLogRepository  {
    fun getAllConditionLogs(): Flow<List<ConditionLog>>;

    fun getConditionLog(id: Int): Flow<ConditionLog>;

    fun getLastConditionLog(): Flow<ConditionLog>;

    suspend fun insertConditionLog(log: ConditionLog);

    suspend fun updateConditionLog(log: ConditionLog);

    suspend fun deleteConditionLog(log: ConditionLog);
}