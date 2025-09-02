package com.luna.cryptoapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Whitepaper(
    val link: String? = "",
    val thumbnail: String? = ""
)