package com.luna.cryptoapp.domain.repository

import com.luna.cryptoapp.domain.model.Coin
import com.luna.cryptoapp.domain.model.CoinDetail

interface CoinRepository {

    suspend fun getCoins(): List<Coin>

    suspend fun getCoinById(coinId: String): CoinDetail
}