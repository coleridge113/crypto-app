package com.luna.cryptoapp.data.repository

import com.luna.cryptoapp.data.remote.CoinPaprikaApi
import com.luna.cryptoapp.data.remote.dto.CoinDetailDto
import com.luna.cryptoapp.data.remote.dto.CoinDto
import javax.inject.Inject

class CoinRemoteSourceImpl @Inject constructor(
    val api: CoinPaprikaApi
) {
    suspend fun getCoins(): List<CoinDto> {
        return api.getAllCoins()
    }

    suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}