package hu.bme.aut.it9p0z.fixkin.di

import android.content.Context
import androidx.datastore.core.DataStoreFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.it9p0z.fixkin.data.dao.ConditionLogDao
import hu.bme.aut.it9p0z.fixkin.data.dao.LifeQualityTestResultLogDao
import hu.bme.aut.it9p0z.fixkin.data.repository.ConditionLogRepository
import hu.bme.aut.it9p0z.fixkin.data.repository.LifeQualityTestResultLogRepository
import hu.bme.aut.it9p0z.fixkin.data.repository.Repository
import hu.bme.aut.it9p0z.fixkin.presentation.data.repository.DataStoreRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreRepository(
        @ApplicationContext context: Context
    ): DataStoreRepository {
        return DataStoreRepository(context = context)
    }

    @Provides
    @Singleton
    fun provideConditionLogRepository(
        dao: ConditionLogDao
    ) : ConditionLogRepository {
        return ConditionLogRepository(dao)
    }

    @Provides
    @Singleton
    fun provideLqtResultRepository(
        dao: LifeQualityTestResultLogDao
    ) : LifeQualityTestResultLogRepository {
        return LifeQualityTestResultLogRepository(dao)
    }
}