package com.luna.cryptoapp.data.repository

import com.luna.cryptoapp.data.local.entity.toCoin
import com.luna.cryptoapp.data.local.entity.toCoinDetail
import com.luna.cryptoapp.domain.model.Coin
import com.luna.cryptoapp.domain.model.CoinDetail
import com.luna.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinLocalSourceImpl: CoinLocalSourceImpl,
) : CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        val coins = coinLocalSourceImpl.getCoins().map { it.toCoin() }
        return coins
    }

    override suspend fun getCoinById(coinId: String): CoinDetail {
        return coinLocalSourceImpl.getCoinById(coinId).toCoinDetail()
    }

}