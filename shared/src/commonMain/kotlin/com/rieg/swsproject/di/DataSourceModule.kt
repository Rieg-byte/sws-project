package com.rieg.swsproject.di

import com.rieg.swsproject.data.remote.KtorSteamNetwork
import com.rieg.swsproject.data.remote.SteamNetworkDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourceModule = module {
    singleOf(::KtorSteamNetwork).bind<SteamNetworkDataSource>()
}