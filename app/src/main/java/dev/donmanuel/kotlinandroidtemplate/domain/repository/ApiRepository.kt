package dev.donmanuel.kotlinandroidtemplate.domain.repository

import com.skydoves.sandwich.ApiResponse
import dev.donmanuel.kotlinandroidtemplate.domain.model.ChampionResponseModel

interface ApiRepository {

    suspend fun getAllChampions(): ApiResponse<ChampionResponseModel>

    suspend fun getChampionByName(name: String): ApiResponse<ChampionResponseModel>
}