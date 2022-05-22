package hu.bme.aut.it9p0z.fixkin.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.it9p0z.fixkin.data.dao.ConditionLogDao
import hu.bme.aut.it9p0z.fixkin.data.dao.LifeQualityTestResultLogDao
import hu.bme.aut.it9p0z.fixkin.data.repository.Repository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(
        @ApplicationContext context: Context,
        conditionLogDao: ConditionLogDao,
        lqtrLogDao: LifeQualityTestResultLogDao
    ): Repository {
        return Repository(
            context = context,
            conditionLogDao = conditionLogDao,
            lqtrLogDao = lqtrLogDao
        )
    }
}