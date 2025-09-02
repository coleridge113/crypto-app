package com.luna.cryptoapp.domain.use_case.get_coins

import com.luna.cryptoapp.common.Resource
import com.luna.cryptoapp.domain.model.Coin
import com.luna.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<Coin>>> {
        return withContext(Dispatchers.IO) {
            flow {
                try {
                    emit(Resource.Loading())
                    val coins = repository.getCoins()
                    emit(Resource.Success(coins))
                } catch (e: HttpException) {
                    emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
                } catch (e: IOException) {
                    emit(Resource.Error("Couldn't reach server. Check your internet connection"))
                }
            }
        }
    }
}