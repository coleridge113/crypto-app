package com.luna.cryptoapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.luna.cryptoapp.data.local.entity.CoinDetailEntity
import com.luna.cryptoapp.domain.model.CoinDetail
import java.io.Serial

data class CoinDetailDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("development_status")
    val developmentStatus: String? = "",
    @SerializedName("first_data_at")
    val firstDataAt: String? = "",
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String? = "",
    val id: String? = "",
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    @SerializedName("links")
    val links: Links? = null,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>? = emptyList(),
    val logo: String,
    val message: String,
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("proof_type")
    val proofType: String,
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String? = "",
    val symbol: String,
    val tags: List<Tag>? = emptyList(),
    val team: List<TeamMember>? = emptyList(),
    val type: String,
    val whitepaper: Whitepaper
)

fun CoinDetailDto.toCoinDetailEntity(): CoinDetailEntity {
    return CoinDetailEntity(
        id = id ?: "",
        description = shortenDescription(description),
        developmentStatus = developmentStatus ?: "",
        firstDataAt = firstDataAt ?: "",
        hardwareWallet = hardwareWallet,
        hashAlgorithm = hashAlgorithm ?: "",
        isActive = isActive,
        isNew = isNew,
        lastDataAt = lastDataAt,
        links = links,
        linksExtended = linksExtended ?: emptyList(),
        logo = logo,
        message = message,
        name = name,
        openSource = openSource,
        orgStructure = orgStructure,
        proofType = proofType,
        rank = rank,
        startedAt = startedAt ?: "",
        symbol = symbol,
        tags = tags ?: emptyList(),
        team = team ?: emptyList(),
        type = type,
        whitepaper = whitepaper
    )
}

fun shortenDescription(description: String): String {
    val regex = Regex("<p>(.*?)</p>", RegexOption.DOT_MATCHES_ALL)
    return regex.find(description)?.groupValues?.get(1)?.trim() ?: ""
}