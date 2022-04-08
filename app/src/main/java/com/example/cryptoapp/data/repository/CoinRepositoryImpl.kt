package com.example.cryptoapp.data.repository

import com.example.cryptoapp.data.remote.CoinPaprikaApi
import com.example.cryptoapp.data.remote.dto.CoinDetailResponse
import com.example.cryptoapp.data.remote.dto.CoinResponse
import com.example.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoins(): List<CoinResponse> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailResponse {
        return api.getCoinById(coinId = coinId)
    }

}