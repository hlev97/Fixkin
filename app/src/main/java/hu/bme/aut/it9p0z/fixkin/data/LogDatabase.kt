package hu.bme.aut.it9p0z.fixkin.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import hu.bme.aut.it9p0z.fixkin.data.dao.ConditionLogDao
import hu.bme.aut.it9p0z.fixkin.data.dao.LifeQualityTestResultLogDao
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.data.model.LifeQualityTestResultLog
import hu.bme.aut.it9p0z.fixkin.data.util.Converters

@Database(entities = [ConditionLog::class, LifeQualityTestResultLog::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class LogDatabase : RoomDatabase() {
    abstract fun ConditionLogDao(): ConditionLogDao
    abstract fun LqtrDao(): LifeQualityTestResultLogDao
}