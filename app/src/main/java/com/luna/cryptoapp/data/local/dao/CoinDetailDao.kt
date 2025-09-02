package com.luna.cryptoapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.luna.cryptoapp.data.local.entity.CoinDetailEntity

@Dao
interface CoinDetailDao {
    @Query("select * from coin_details where id = :coinId")
    fun getCoinById(coinId: String): CoinDetailEntity

    @Insert

}