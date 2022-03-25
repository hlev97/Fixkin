package hu.bme.aut.it9p0z.fixkin.data

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.bme.aut.it9p0z.fixkin.data.dao.ConditionLogDao
import hu.bme.aut.it9p0z.fixkin.data.dao.LifeQualityTestResultLogDao
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.data.model.LifeQualityTestResultLog

@Database(entities = [ConditionLog::class, LifeQualityTestResultLog::class], version = 1, exportSchema = false)
abstract class LogDatabase : RoomDatabase() {
    abstract fun ConditionLogDao(): ConditionLogDao
    abstract fun LqtrDao(): LifeQualityTestResultLogDao
}