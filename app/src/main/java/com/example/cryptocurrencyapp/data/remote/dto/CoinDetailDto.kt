package com.example.cryptocurrencyapp.data.remote.dto

import com.example.cryptocurrencyapp.domain.model.CoinDetail
import com.google.gson.annotations.SerializedName

data class CoinDetailDto(
    val description: String,
    val development_status: String,
    val first_data_at: String,
    val hardware_wallet: Boolean,
    val hash_algorithm: String,
    val id: String,
    @SerializedName("is_active")
    val is_active: Boolean,
    val is_new: Boolean,
    val last_data_at: String,
    val links: Links,
    @SerializedName("links_extended")
    val links_extended: List<LinksExtended>,
    val message: String,
    val name: String,
    @SerializedName("open_source")
    val open_source: Boolean,
    @SerializedName("org_structure")
    val org_structure: String,
    @SerializedName("proof_type")
    val proof_type: String,
    val rank: Int,
    @SerializedName("started_at")
    val started_at: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val type: String,
    val whitepaper: Whitepaper
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = is_active,
        tags = tags.map { it.name },
        team = team
    )
}