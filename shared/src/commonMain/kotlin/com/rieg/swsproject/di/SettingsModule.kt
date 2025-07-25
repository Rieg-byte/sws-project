package com.rieg.swsproject.di

import com.russhwolf.settings.Settings
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val settingsModule = module {
    singleOf(::Settings)
}