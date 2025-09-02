package com.luna.cryptoapp.domain.use_case.get_coin

import com.luna.cryptoapp.common.Resource
import com.luna.cryptoapp.domain.model.CoinDetail
import com.luna.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> {
        return withContext(Dispatchers.IO) {
            flow {
                try {
                    emit(Resource.Loading())
                    val coin = repository.getCoinById(coinId)
                    emit(Resource.Success(coin))
                } catch (e: HttpException) {
                    emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
                } catch (e: IOException) {
                    emit(Resource.Error("Couldn't reach server. Check your internet connection"))
                }
            }
        }
    }
}