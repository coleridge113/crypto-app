package com.luna.cryptoapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.luna.cryptoapp.data.local.entity.CoinEntity

@Dao
interface CoinDao {
    @Query("select * from coins")
    suspend fun getCoins(): List<CoinEntity>

    @Insert
    suspend fun insertCoins(coins: List<CoinEntity>)
}