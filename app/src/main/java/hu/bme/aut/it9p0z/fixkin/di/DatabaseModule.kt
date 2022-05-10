package hu.bme.aut.it9p0z.fixkin.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.it9p0z.fixkin.data.LogDatabase
import hu.bme.aut.it9p0z.fixkin.data.dao.ConditionLogDao
import hu.bme.aut.it9p0z.fixkin.data.dao.LifeQualityTestResultLogDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) : LogDatabase {
        return Room.databaseBuilder(
            context,
            LogDatabase::class.java,
            "log_database"
        ).createFromAsset("database/log_database.db").build()
    }

    @Provides
    @Singleton
    fun provideConditionLogDao(logDatabase: LogDatabase) : ConditionLogDao {
        return logDatabase.ConditionLogDao()
    }

    @Provides
    @Singleton
    fun provideLifeQualityTestResultLogDao(logDatabase: LogDatabase) : LifeQualityTestResultLogDao {
        return logDatabase.LqtrDao()
    }
}