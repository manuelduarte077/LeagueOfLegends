package dev.donmanuel.kotlinandroidtemplate.ui.screens.champion_details

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.donmanuel.kotlinandroidtemplate.domain.model.ChampionModel
import dev.donmanuel.kotlinandroidtemplate.domain.repository.ApiRepository
import dev.donmanuel.kotlinandroidtemplate.ui.util.ChampionDetails
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChampionDetailsViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var champion = mutableStateOf<ChampionModel?>(null)

    init {

        val args = savedStateHandle.toRoute<ChampionDetails>()

        viewModelScope.launch {
            apiRepository.getChampionByName(args.name)
                .onSuccess {
                    Log.d("TAG", "ChampionDetailsViewModel: $data")
                    champion.value = data.champion.values.firstOrNull()
                }
                .onError {
                    Log.d("TAG", "ChampionDetailsViewModel: ${message()}")
                }
        }
    }
}