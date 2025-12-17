package com.example.mykmpapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = {},
        title = "Firestorekmp"
    ) {
        App()
    }
}
