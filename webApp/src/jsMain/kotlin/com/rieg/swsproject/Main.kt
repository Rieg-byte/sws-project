package com.rieg.swsproject

import app.softwork.routingcompose.BrowserRouter
import app.softwork.routingcompose.Router
import com.rieg.swsproject.components.MainContent
import com.rieg.swsproject.di.initKoin
import com.rieg.swsproject.pages.main.MainPage
import com.rieg.swsproject.pages.main.MainPageViewModel
import com.rieg.swsproject.pages.stats.StatsPage
import com.rieg.swsproject.styles.AppStylesheet
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        initKoin()
        Style(AppStylesheet)
        MainContent {
            BrowserRouter(initPath = "/") {
                val router = Router.current
                route("/") {
                    MainPage(onNavigateStats = {
                        router.navigate("/stats")
                    },
                        mainPageViewModel = MainPageViewModel()
                    )
                }
                route("/stats") {
                    StatsPage()
                }
            }
        }
    }
}