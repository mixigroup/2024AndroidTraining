package jp.co.mixi.androidtraining.sns

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() {
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "SNS",
        ) {
            SnsApp()
        }
    }
}
