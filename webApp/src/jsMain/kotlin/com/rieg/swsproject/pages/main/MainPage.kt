package com.rieg.swsproject.pages.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.rieg.swsproject.components.Column
import com.rieg.swsproject.components.Row
import com.rieg.swsproject.components.button.SButton
import com.rieg.swsproject.components.inputs.STextInput
import com.rieg.swsproject.theme.ColorTheme
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun MainPage(
    onNavigateStats: () -> Unit,
    mainPageViewModel: MainPageViewModel
) {
    val mainPageUiState by mainPageViewModel.mainPageUiState.collectAsState()
    val steamApiKey = mainPageUiState.steamApiKey
    Column(
        attrs = {
            style {
                height(100.vh)
                gap(20.px)
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.Center)
            }
        }
    ) {
        SteamApiForm(
            steamApi = steamApiKey,
            onSteamApiChange = mainPageViewModel::updateSteamApi,
            isError = mainPageUiState.isError
        )
        UrlProfileForm(
            urlProfile = mainPageUiState.profileUrl,
            onUrlProfileChange = mainPageViewModel::updateProfileUrl,
            onClick = onNavigateStats
        )
    }
}

@Composable
fun SteamApiForm(
    steamApi: String,
    onSteamApiChange: (String) -> Unit,
    isError: Boolean
) {
    Column(
        attrs = {
            style {
                width(100.percent)
            }
        }
    ) {
        Row(
            attrs = {
                style {
                    justifyContent(JustifyContent.SpaceBetween)
                    marginBottom(16.px)
                    color(ColorTheme.onSurface)
                }
            }
        ) {
            Span {
                Text("Введите api-ключ Steam")
            }
            A(
                href = "https://steamcommunity.com/dev/apikey",
            ) {
                Text("Получить api-ключ")
            }
        }
        STextInput(
            value = steamApi,
            onValueChange = onSteamApiChange,
            placeholder = "Введите ключ",
            isError = isError,
            attrs = {
                style {
                    height(60.px)
                }
            }
        )
    }
}

@Composable
fun UrlProfileForm(
    urlProfile: String,
    onUrlProfileChange: (String) -> Unit,
    onClick: () -> Unit
) {
    Column(
        attrs = {
            style {
                width(100.percent)
            }
        }
    ) {
        Row(
            attrs = {
                style {
                    justifyContent(JustifyContent.SpaceBetween)
                    marginBottom(16.px)
                    color(ColorTheme.onSurface)
                }
            }
        ) {
            Span {
                Text("Введите ссылку на профиль")
            }
        }
        UrlProfileInput(
            urlProfile = urlProfile,
            onUrlProfileChange = onUrlProfileChange,
            onClick = onClick
        )
    }
}

@Composable
fun UrlProfileInput(
    urlProfile: String,
    onUrlProfileChange: (String) -> Unit,
    onClick: () -> Unit
) {
    Row(
        attrs = {
            style {
                justifyContent(JustifyContent.Center)
                height(60.px)
                width(100.percent)
                gap(20.px)
            }
        }
    ) {
        STextInput(
            value = urlProfile,
            placeholder = "Пример: https://steamcommunity.com/id/username",
            onValueChange = onUrlProfileChange,
            attrs = {
                style {
                    width(100.percent)
                    height(60.px)
                }
            }
        )
        SButton(
            action = onClick,
            attrs = {
                style {
                    width(140.px)
                    height(60.px)
                }
            }
        ) {
            Text("Получить данные")
        }
    }
}