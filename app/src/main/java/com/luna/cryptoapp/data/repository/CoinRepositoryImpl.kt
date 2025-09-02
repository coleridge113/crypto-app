package com.luna.cryptoapp.data.repository

import com.luna.cryptoapp.domain.model.Coin
import com.luna.cryptoapp.domain.model.CoinDetail
import com.luna.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinLocalSourceImpl: CoinLocalSourceImpl,
) : CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        TODO("Not yet implemented")
    }

    override suspend fun getCoinById(coinId: String): CoinDetail {
        TODO("Not yet implemented")
    }

}