package dev.donmanuel.kotlinandroidtemplate.ui.screens.champion_details

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import dev.donmanuel.kotlinandroidtemplate.data.repository.ApiRepositoryImpl
import dev.donmanuel.kotlinandroidtemplate.domain.model.ChampionModel
import dev.donmanuel.kotlinandroidtemplate.ui.screens.champion_details.composable.ChampionHeader
import dev.donmanuel.kotlinandroidtemplate.ui.screens.champion_details.composable.ChampionLore
import dev.donmanuel.kotlinandroidtemplate.ui.screens.champion_details.composable.ChampionPassive
import dev.donmanuel.kotlinandroidtemplate.ui.screens.champion_details.composable.ChampionSpell

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChampionDetailsScreen(
    champion: ChampionModel
) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Back") },
                navigationIcon = {
                    IconButton(onClick = {
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "backIcon")
                    }
                },
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
                windowInsets = TopAppBarDefaults.windowInsets,
            )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding
        ) {
            item {
                AsyncImage(
                    model = ApiRepositoryImpl.imageSplashUrl + "${champion.name}_0.jpg",
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )

                ChampionHeader(
                    champion = champion,
                    modifier = Modifier.padding(
                        horizontal = 10.dp,
                        vertical = 6.dp
                    )
                )

                ChampionLore(
                    lore = champion.lore ?: "",
                    modifier = Modifier.padding(
                        horizontal = 20.dp,
                        vertical = 6.dp
                    )
                )

                champion.passive?.let { passive ->
                    ChampionPassive(
                        passive = passive,
                        modifier = Modifier.padding(
                            horizontal = 6.dp,
                            vertical = 10.dp
                        )
                    )
                }

                champion.spells.forEach { spell ->
                    ChampionSpell(
                        spell = spell,
                        modifier = Modifier.padding(
                            horizontal = 6.dp,
                            vertical = 10.dp
                        )
                    )
                }
            }
        }
    }
}