package hu.bme.aut.it9p0z.fixkin.data.dao

import androidx.room.*
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import kotlinx.coroutines.flow.Flow

@Dao
interface ConditionLogDao {
    @Query("SELECT * FROM condition_logs")
    fun getLogs(): Flow<List<ConditionLog>>

    @Query("SELECT * FROM condition_logs WHERE id=:id")
    fun getLog(id: Int): Flow<ConditionLog>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLog(log: ConditionLog)

    @Delete
    suspend fun deleteLog(log: ConditionLog)

    @Update
    suspend fun updateLog(log: ConditionLog)
}