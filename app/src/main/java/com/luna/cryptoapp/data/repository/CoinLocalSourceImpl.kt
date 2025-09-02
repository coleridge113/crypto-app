package com.luna.cryptoapp.data.repository

import com.luna.cryptoapp.data.local.AppDatabase
import com.luna.cryptoapp.data.local.entity.CoinDetailEntity
import com.luna.cryptoapp.data.local.entity.CoinEntity
import com.luna.cryptoapp.data.remote.dto.toCoinDetailEntity
import com.luna.cryptoapp.data.remote.dto.toCoinEntity
import javax.inject.Inject

class CoinLocalSourceImpl @Inject constructor(
    private val db: AppDatabase,
    private val remote: CoinRemoteSourceImpl
) {

    suspend fun getCoins(): List<CoinEntity> {
        val coins = db.coinDao().getCoins()
        return coins.ifEmpty {
            val remoteData = remote.getCoins().map { it.toCoinEntity() }
            db.coinDao().insertCoins(remoteData)
            remoteData
        }
    }

    suspend fun getCoinById(coinId: String): CoinDetailEntity {
        return try {
            db.coinDetailDao().getCoinById(coinId)
        } catch (_: Exception) {
            val remoteData = remote.getCoinById(coinId).toCoinDetailEntity()
            db.coinDetailDao().insertCoin(remoteData)
            remoteData
        }
    }
}