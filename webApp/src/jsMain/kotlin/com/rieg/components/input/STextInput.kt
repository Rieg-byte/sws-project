package com.rieg.components.input

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.TextInput

@Composable
fun STextInput(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String? = null,
    attrs:  (InputAttrsScope<String>.() -> Unit)? = null,
) {
    Style(STextInputStyle)
    TextInput(
        value = value,
        attrs = {
            placeholder(placeholder ?: "")
            classes(STextInputStyle.base)
            onInput { event ->
                onValueChange(event.value)
            }
            attrs?.invoke(this)
        }
    )
}