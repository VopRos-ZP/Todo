package ru.vopros.todo.ui.screen.todoList

import ru.vopros.todo.domain.model.Todo

data class TodoListViewState(
    val isLoading: Boolean = false,
    val todoList: List<Todo> = emptyList(),
    val isShowError: Boolean = false,
    val error: String? = null,
)
