package com.rieg.swsproject.styles

import com.rieg.swsproject.theme.ColorTheme
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.fontFamily

object AppStylesheet : StyleSheet() {
    init {
        "*" style {
            backgroundColor(ColorTheme.surface)
            fontFamily("Montserrat", "sans-serif")
        }
    }
}