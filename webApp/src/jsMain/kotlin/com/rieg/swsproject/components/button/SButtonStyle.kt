package com.rieg.swsproject.components.button

import com.rieg.swsproject.styles.BorderRadius
import com.rieg.swsproject.theme.ColorTheme
import com.rieg.swsproject.utils.lighten
import org.jetbrains.compose.web.css.*

object SButtonStyle : StyleSheet() {
    val base by style {
        padding(16.px)
        borderRadius(BorderRadius.roundedMd)
        border(
            width = 0.px,
            style = LineStyle.None,
            color = null
        )
        color(ColorTheme.onPrimary)
        backgroundColor(ColorTheme.primary)
        self + hover style {
            backgroundColor(ColorTheme.primary.lighten(10))
        }

        self + focus style {
            backgroundColor(ColorTheme.primary.lighten(20))
        }
    }
}