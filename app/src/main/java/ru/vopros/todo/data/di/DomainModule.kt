package ru.vopros.todo.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.vopros.todo.domain.usecase.AddTodoUseCase
import ru.vopros.todo.domain.usecase.DeleteTodoUseCase
import ru.vopros.todo.domain.usecase.TodoListUseCase
import ru.vopros.todo.domain.usecase.UpdateTodoUseCase

private val usecaseModule = module {
    singleOf(::TodoListUseCase)
    singleOf(::AddTodoUseCase)
    singleOf(::UpdateTodoUseCase)
    singleOf(::DeleteTodoUseCase)
}

internal val domainModule = module {
    includes(
        usecaseModule
    )
}