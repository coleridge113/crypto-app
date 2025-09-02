package com.luna.cryptoapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.luna.cryptoapp.data.local.entity.CoinDetailEntity
import com.luna.cryptoapp.domain.model.CoinDetail

data class CoinDetailDto(
    val description: String,
    val developmentStatus: String? = "",
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    val links: Links,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>,
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
    val startedAt: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val type: String,
    val whitepaper: Whitepaper
)

fun CoinDetailDto.toCoinDetailEntity(): CoinDetailEntity {
    return CoinDetailEntity(
        id = id,
        description = description,
        developmentStatus = developmentStatus ?: "",
        firstDataAt = firstDataAt,
        hardwareWallet = hardwareWallet,
        hashAlgorithm = hashAlgorithm,
        isActive = isActive,
        isNew = isNew,
        lastDataAt = lastDataAt,
        links = links,
        linksExtended = linksExtended,
        logo = logo,
        message = message,
        name = name,
        openSource = openSource,
        orgStructure = orgStructure,
        proofType = proofType,
        rank = rank,
        startedAt = startedAt,
        symbol = symbol,
        tags = tags,
        team = team,
        type = type,
        whitepaper = whitepaper
    )
}

fun shortenDescription(description: String): String {
    val regex = Regex("<p>(.*?)</p>", RegexOption.DOT_MATCHES_ALL)
    return regex.find(description)?.groupValues?.get(1)?.trim() ?: ""
}