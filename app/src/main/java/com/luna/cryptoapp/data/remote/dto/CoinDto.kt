package com.luna.cryptoapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.luna.cryptoapp.data.local.entity.CoinEntity
import com.luna.cryptoapp.domain.model.Coin

data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoinEntity(): CoinEntity {
    return CoinEntity(
        id = id,
        isActive = isActive,
        isNew = isNew,
        name = name,
        rank = rank,
        symbol = symbol,
        type = type
    )
}