package dev.donmanuel.kotlinandroidtemplate.ui.util

import kotlinx.serialization.Serializable

@Serializable
data object ChampionList

@Serializable
data class ChampionDetails(val name: String)