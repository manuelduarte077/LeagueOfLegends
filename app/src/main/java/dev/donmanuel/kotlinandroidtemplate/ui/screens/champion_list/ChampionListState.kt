package dev.donmanuel.kotlinandroidtemplate.ui.screens.champion_list

import dev.donmanuel.kotlinandroidtemplate.domain.model.ChampionModel

data class ChampionListState(
    val searchText: String = "",
    val champions: List<ChampionModel> = emptyList(),
    val filteredChampions: List<ChampionModel> = emptyList(),
)