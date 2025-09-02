package com.luna.cryptoapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Stats(
    val contributors: Int? = 0,
    val followers: Int? = 0,
    val stars: Int? = 0,
    val subscribers: Int? = 0
)