package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.data.remote.dto.CoinDetailResponse
import com.example.cryptoapp.data.remote.dto.CoinResponse

interface CoinRepository {

    suspend fun getCoins(): List<CoinResponse>

    suspend fun getCoinById(coinId: String): CoinDetailResponse
}