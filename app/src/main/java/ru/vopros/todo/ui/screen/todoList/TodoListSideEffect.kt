package ru.vopros.todo.ui.screen.todoList

import ru.vopros.todo.domain.model.Todo

sealed interface TodoListSideEffect {
    data object OnAddTodoClick : TodoListSideEffect
    data class OnTodoItemClick(val value: Todo) : TodoListSideEffect
}