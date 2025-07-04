package com.rieg.components.card

import com.rieg.styles.BorderRadius
import com.rieg.theme.ColorTheme
import org.jetbrains.compose.web.css.*

object CardStyle: StyleSheet() {
    val base by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        borderRadius(BorderRadius.roundedMd)
        color(ColorTheme.onSurface)
        backgroundColor(ColorTheme.surfaceContainerLow)
        padding(16.px)
    }
}