package com.rieg.swsproject.di

import com.rieg.swsproject.data.datastore.DataStore
import com.rieg.swsproject.data.datastore.DataStoreImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataStoreModule = module {
    singleOf(::DataStoreImpl).bind<DataStore>()
}