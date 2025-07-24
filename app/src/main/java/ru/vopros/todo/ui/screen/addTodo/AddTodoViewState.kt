package ru.vopros.todo.ui.screen.addTodo

import ru.vopros.todo.domain.model.Priority

data class AddTodoViewState(
    val isLoading: Boolean = false,
    val title: String = "",
    val data: String = "",
    val priority: Priority = Priority.NORMAL,
)
