package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.remote.dto.CoinDetailResponse
import com.example.cryptoapp.data.remote.dto.CoinResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinResponse>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(
        @Path("coinId") coinId: String
    ): CoinDetailResponse
}