package com.rieg.swsproject.pages.main

data class MainPageUiState(
    val steamApiKey: String = "",
    val profileUrl: String = "",
    val isError: Boolean = false
)