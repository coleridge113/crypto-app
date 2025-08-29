package com.luna.cryptoapp.domain.repository

import com.luna.cryptoapp.data.remote.dto.CoinDetailDto
import com.luna.cryptoapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}