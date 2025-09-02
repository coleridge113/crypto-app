package com.luna.cryptoapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.luna.cryptoapp.data.remote.dto.Links
import com.luna.cryptoapp.data.remote.dto.LinksExtended
import com.luna.cryptoapp.data.remote.dto.Tag
import com.luna.cryptoapp.data.remote.dto.TeamMember
import com.luna.cryptoapp.data.remote.dto.Whitepaper
import com.luna.cryptoapp.domain.model.CoinDetail

@Entity(tableName = "coin_details")
data class CoinDetailEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val description: String,
    val developmentStatus: String,
    @ColumnInfo("first_data_at")
    val firstDataAt: String,
    @ColumnInfo("hardware_wallet")
    val hardwareWallet: Boolean,
    @ColumnInfo("hash_algorithm")
    val hashAlgorithm: String,
    @ColumnInfo("is_active")
    val isActive: Boolean,
    @ColumnInfo("is_new")
    val isNew: Boolean,
    @ColumnInfo("last_data_at")
    val lastDataAt: String,
    val links: Links,
    @ColumnInfo("links_extended")
    val linksExtended: List<LinksExtended>,
    val logo: String,
    val message: String,
    val name: String,
    @ColumnInfo("open_source")
    val openSource: Boolean,
    @ColumnInfo("org_structure")
    val orgStructure: String,
    @ColumnInfo("proof_type")
    val proofType: String,
    val rank: Int,
    @ColumnInfo("started_at")
    val startedAt: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val type: String,
    val whitepaper: Whitepaper
)

fun CoinDetailEntity.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = shortenDescription(description),
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}

fun shortenDescription(description: String): String {
    val regex = Regex("<p>(.*?)</p>", RegexOption.DOT_MATCHES_ALL)
    return regex.find(description)?.groupValues?.get(1)?.trim() ?: ""
}