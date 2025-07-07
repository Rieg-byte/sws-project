package com.rieg.swsproject.components.inputs

import com.rieg.swsproject.styles.BorderRadius
import com.rieg.swsproject.theme.ColorTheme
import com.rieg.swsproject.utils.boxShadow
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
    }
    val isValid by style {

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

    val isInvalid by style {

        self + focus style {
            color(ColorTheme.onSurface)
            border(
                width = 1.px,
                style = LineStyle.Solid,
                color = ColorTheme.errorContainer
            )
            boxShadow(
                offsetX = 0.px,
                offsetY = 0.px,
                blurRadius = 0.px,
                spreadRadius = 1.px,
                color = ColorTheme.errorContainer
            )
            outline("none")
        }
    }
}