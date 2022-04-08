package com.example.cryptoapp.data.remote.dto

import com.example.cryptoapp.domain.model.CoinDetail
import com.google.gson.annotations.SerializedName

data class CoinDetailResponse(
    val contract: String,
    val contracts: List<Contract>,
    val description: String,
    @SerializedName("development_status")
    val developmentStatus: String,
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
    val message: String,
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    val parent: Parent,
    val platform: String,
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
) {
    data class Contract(
        val contract: String,
        val platform: String,
        val type: String
    )

    data class Links(
        val explorer: List<String>,
        val facebook: List<String>,
        val medium: Any,
        val reddit: List<String>,
        @SerializedName("source_code")
        val sourceCode: List<String>,
        val website: List<String>,
        val youtube: List<String>
    )

    data class LinksExtended(
        val stats: Stats,
        val type: String,
        val url: String
    )

    data class Parent(
        val id: String,
        val name: String,
        val symbol: String
    )

    data class Stats(
        val contributors: Int,
        val stars: Int,
        val subscribers: Int
    )

    data class Tag(
        @SerializedName("coin_counter")
        val coinCounter: Int,
        @SerializedName("ico_counter")
        val icoCounter: Int,
        val id: String,
        val name: String
    )

    data class TeamMember(
        val id: String,
        val name: String,
        val position: String
    )

    data class Whitepaper(
        val link: String,
        val thumbnail: String
    )
}

fun CoinDetailResponse.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}