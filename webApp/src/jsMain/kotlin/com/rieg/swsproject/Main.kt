package com.rieg.swsproject

import app.softwork.routingcompose.BrowserRouter
import app.softwork.routingcompose.Router
import com.rieg.swsproject.components.MainContent
import com.rieg.swsproject.pages.main.MainPage
import com.rieg.swsproject.pages.stats.StatsPage
import com.rieg.swsproject.styles.AppStylesheet
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStylesheet)
        MainContent {
            BrowserRouter(initPath = "/") {
                val router = Router.current
                route("/") {
                    MainPage(onNavigateStats = {
                        router.navigate("/stats")
                    }
                    )
                }
                route("/stats") {
                    StatsPage()
                }
            }
        }
    }
}