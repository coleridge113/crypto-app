package com.luna.cryptoapp.di

import com.luna.cryptoapp.common.Constants.BASE_URL
import com.luna.cryptoapp.data.local.AppDatabase
import com.luna.cryptoapp.data.remote.CoinPaprikaApi
import com.luna.cryptoapp.data.repository.CoinLocalSourceImpl
import com.luna.cryptoapp.data.repository.CoinRemoteSourceImpl
import com.luna.cryptoapp.data.repository.CoinRepositoryImpl
import com.luna.cryptoapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteSource(api: CoinPaprikaApi): CoinRemoteSourceImpl {
        return CoinRemoteSourceImpl(api)
    }

    @Provides
    @Singleton
    fun provideLocalSource(db: AppDatabase, remote: CoinRemoteSourceImpl): CoinLocalSourceImpl {
        return CoinLocalSourceImpl(db, remote)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(local: CoinLocalSourceImpl): CoinRepository {
        return CoinRepositoryImpl(local)
    }
}