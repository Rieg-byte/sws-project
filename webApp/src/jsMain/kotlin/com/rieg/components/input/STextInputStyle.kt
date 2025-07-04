package com.rieg.components.input

import com.rieg.styles.BorderRadius
import com.rieg.theme.ColorTheme
import com.rieg.utils.boxShadow
import org.jetbrains.compose.web.css.*

object STextInputStyle : StyleSheet() {
    val base by style {
        border(
            width = 1.px,
            style = LineStyle.Solid,
            color = ColorTheme.outline
        )
        borderRadius(BorderRadius.roundedMd)
        backgroundColor(ColorTheme.surface)
        fontSize(1.cssRem)
        color(ColorTheme.onSurface)
        paddingLeft(16.px)
        paddingRight(16.px)

        self + hover style {
            border(
                width = 1.px,
                style = LineStyle.Solid,
                color = ColorTheme.onSurface
            )
        }

        self + focus style {
            color(ColorTheme.onSurface)
            border(
                width = 1.px,
                style = LineStyle.Solid,
                color = ColorTheme.primary
            )
            boxShadow(
                offsetX = 0.px,
                offsetY = 0.px,
                blurRadius = 0.px,
                spreadRadius = 1.px,
                color = ColorTheme.primary
            )
            outline("none")
        }
    }
}