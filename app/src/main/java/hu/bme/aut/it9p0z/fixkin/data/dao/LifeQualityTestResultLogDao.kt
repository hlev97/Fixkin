package hu.bme.aut.it9p0z.fixkin.data.dao

import androidx.room.*
import hu.bme.aut.it9p0z.fixkin.data.model.LifeQualityTestResultLog
import kotlinx.coroutines.flow.Flow

@Dao
interface LifeQualityTestResultLogDao {
    @Query("SELECT * FROM test_results")
    fun getLogs(): Flow<List<LifeQualityTestResultLog>>

    @Query("SELECT * FROM test_results WHERE id=:id")
    fun getLog(id: Int): Flow<LifeQualityTestResultLog>

    @Query("SELECT * FROM (SELECT * FROM test_results ORDER BY id DESC) LIMIT 1")
    fun getLastLog(): Flow<LifeQualityTestResultLog>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLog(log: LifeQualityTestResultLog)

    @Delete
    suspend fun deleteLog(log: LifeQualityTestResultLog)

    @Update
    suspend fun updateLog(log: LifeQualityTestResultLog)
}
