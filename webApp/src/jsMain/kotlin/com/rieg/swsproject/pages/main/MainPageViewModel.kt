package com.rieg.swsproject.pages.main

import com.rieg.swsproject.domain.repository.SteamApiKeyRepository
import com.rieg.swsproject.utils.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainPageViewModel: ViewModel(), KoinComponent {
    private val steamApiKeyRepository: SteamApiKeyRepository by inject()
    private val _mainPageUiState = MutableStateFlow(MainPageUiState())
    val mainPageUiState = _mainPageUiState.asStateFlow()

    init {
        getSteamApi()
    }

    fun getSteamApi() = viewModelScope.launch {
        val steamApiKey = steamApiKeyRepository.getApiKey()
        if (steamApiKey.apiKey.isNotBlank()) {
            _mainPageUiState.update {
                it.copy(
                    steamApiKey = steamApiKey.apiKey
                )
            }
        }
    }

    fun updateSteamApi(steamApiKey: String) {
        _mainPageUiState.update { state ->
            state.copy(
                steamApiKey = steamApiKey,
                isError = steamApiKey.length != 32
            )
        }

        when {
            steamApiKey.length == 32 -> saveSteamApi(steamApiKey)
            steamApiKey.isEmpty() -> removeSteamApi()
        }
    }

    fun updateProfileUrl(profileUrl: String) {
        _mainPageUiState.update {
            it.copy(
                profileUrl = profileUrl
            )
        }
    }

    private fun saveSteamApi(steamApiKey: String) = viewModelScope.launch {
        steamApiKeyRepository.saveApiKey(steamApiKey)
    }

    private fun removeSteamApi() = viewModelScope.launch {
        steamApiKeyRepository.removeApiKey()
    }
}