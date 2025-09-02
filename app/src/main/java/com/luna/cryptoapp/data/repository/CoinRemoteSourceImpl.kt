package com.luna.cryptoapp.data.repository

import com.luna.cryptoapp.data.remote.CoinPaprikaApi
import com.luna.cryptoapp.data.remote.dto.CoinDetailDto
import com.luna.cryptoapp.data.remote.dto.CoinDto
import com.luna.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getAllCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}