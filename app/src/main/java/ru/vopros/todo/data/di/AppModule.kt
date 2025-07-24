package ru.vopros.todo.data.di

import org.koin.dsl.module

internal val appModule = module {
    includes(
        dataModule,
        domainModule,
        presentationModule,
    )
}