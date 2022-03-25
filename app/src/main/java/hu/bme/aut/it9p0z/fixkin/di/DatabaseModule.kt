package hu.bme.aut.it9p0z.fixkin.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.it9p0z.fixkin.data.LogDatabase
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
            "log_databse"
        ).build()
    }
}