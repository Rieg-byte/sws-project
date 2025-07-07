package com.rieg.swsproject.di

import com.rieg.swsproject.data.repository.SteamApiKeyRepositoryImpl
import com.rieg.swsproject.domain.repository.SteamApiKeyRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::SteamApiKeyRepositoryImpl).bind<SteamApiKeyRepository>()
}