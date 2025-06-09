package dev.donmanuel.kotlinandroidtemplate.presentation.screens.champion_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.donmanuel.kotlinandroidtemplate.presentation.screens.champion_list.composable.ChampionCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChampionListScreen(
    state: ChampionListState,
    onValueChange: (String) -> Unit,
    navigate: (String) -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "League Of Legends",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            OutlinedTextField(
                singleLine = true,
                value = state.searchText,
                onValueChange = onValueChange,
                placeholder = {
                    Text(text = "Search for champs")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = null
                    )
                },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(state.filteredChampions.ifEmpty { state.champions }) { champion ->
                    ChampionCard(
                        champion = champion,
                        modifier = Modifier
                            .animateItem()
                            .clickable {
                                champion.name?.let(navigate)
                            }
                    )
                }
            }
        }
    }
}