package com.rieg.pages.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.rieg.components.Column
import com.rieg.components.Row
import com.rieg.components.button.SButton
import com.rieg.components.input.STextInput
import com.rieg.theme.ColorTheme
import kotlinx.browser.localStorage
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.set

const val WEB_API = "webApi"

@Composable
fun MainPage(
    onNavigateStats: () -> Unit
) {
    val localSteamApi = localStorage.getItem(WEB_API) ?: ""
    val steamApi = remember { mutableStateOf(localSteamApi) }
    val urlProfile = remember { mutableStateOf("") }
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
            steamApi = steamApi.value,
            onSteamApiChange = {
                steamApi.value = it
            },
            onClick = {
                localStorage[WEB_API] = steamApi.value
            }
        )
        UrlProfileForm(
            urlProfile = urlProfile.value,
            onUrlProfileChange = {
                urlProfile.value = it
            },
            onClick = onNavigateStats
        )
    }
}

@Composable
fun SteamApiForm(
    steamApi: String,
    onSteamApiChange: (String) -> Unit,
    onClick: () -> Unit
) {
    Column {
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
        SteamApiInput(
            steamApi = steamApi,
            onSteamApiChange = onSteamApiChange,
            onClick = onClick
        )
    }
}

@Composable
fun UrlProfileForm(
    urlProfile: String,
    onUrlProfileChange: (String) -> Unit,
    onClick: () -> Unit
) {
    Column {
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
fun SteamApiInput(
    steamApi: String,
    onSteamApiChange: (String) -> Unit,
    onClick: () -> Unit
) {
    Row(
        attrs = {
            style {
                justifyContent(JustifyContent.Center)
                width(100.percent)
                gap(20.px)
            }
        }
    ) {

        STextInput(
            value = steamApi,
            placeholder = "Введите ключ",
            onValueChange = onSteamApiChange,
            attrs = {
                style {
                    width(500.px)
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
            Text("Сохранить")
        }
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
                    width(500.px)
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