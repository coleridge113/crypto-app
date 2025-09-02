package com.luna.cryptoapp.di

import android.content.Context
import androidx.room.Room
import com.luna.cryptoapp.data.local.AppDatabase
import com.luna.cryptoapp.data.local.dao.CoinDao
import com.luna.cryptoapp.data.local.dao.CoinDetailDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, "crypto_db").build()
    }

    @Provides
    @Singleton
    fun provideCoinDao(db: AppDatabase): CoinDao {
        return db.coinDao()
    }

    @Provides
    @Singleton
    fun provideCoinDetailDao(db: AppDatabase): CoinDetailDao {
        return db.coinDetailDao()
    }

}