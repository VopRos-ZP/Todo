package ru.vopros.todo.data.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.vopros.todo.ui.screen.addTodo.AddTodoViewModel
import ru.vopros.todo.ui.screen.todoList.TodoListViewModel

private val viewModelModule = module {
    viewModelOf(::TodoListViewModel)
    viewModelOf(::AddTodoViewModel)
}

internal val presentationModule = module {
    includes(
        viewModelModule
    )
}