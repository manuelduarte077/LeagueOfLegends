package dev.donmanuel.kotlinandroidtemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.donmanuel.kotlinandroidtemplate.presentation.screens.champion_details.ChampionDetailsScreen
import dev.donmanuel.kotlinandroidtemplate.presentation.screens.champion_details.ChampionDetailsViewModel
import dev.donmanuel.kotlinandroidtemplate.presentation.screens.champion_list.ChampionListScreen
import dev.donmanuel.kotlinandroidtemplate.presentation.screens.champion_list.ChampionListViewModel
import dev.donmanuel.kotlinandroidtemplate.presentation.theme.KotlinAndroidTemplateTheme
import dev.donmanuel.kotlinandroidtemplate.presentation.util.ChampionDetails
import dev.donmanuel.kotlinandroidtemplate.presentation.util.ChampionList

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinAndroidTemplateTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = ChampionList) {

                    composable<ChampionList> {
                        val viewModel = hiltViewModel<ChampionListViewModel>()
                        val state by viewModel.state.collectAsStateWithLifecycle()

                        ChampionListScreen(
                            state = state,
                            onValueChange = viewModel::onSearchTextChange,
                            navigate = { name ->
                                navController.navigate(ChampionDetails(name))
                            }
                        )
                    }

                    composable<ChampionDetails> {
                        val viewModel = hiltViewModel<ChampionDetailsViewModel>()

                        viewModel.champion.value?.let {
                            ChampionDetailsScreen(
                                champion = it,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}
