package com.qq.runing.di

import android.content.Context
import androidx.room.Room
import com.qq.runing.db.RunningDatabase
import com.qq.runing.other.Constants.RUNNING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppComponent {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context, RunningDatabase::class.java, RUNNING_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideRunDAO(db: RunningDatabase) = db.getRunDao()
}