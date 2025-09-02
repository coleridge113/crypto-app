package com.luna.cryptoapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class LinksExtended(
    @SerializedName("stats")
    val stats: Stats? = null,
    val type: String,
    val url: String
)