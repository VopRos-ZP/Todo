package ru.vopros.todo.ui.screen.addTodo

sealed interface AddTodoSideEffect {
    data object OnBackClick : AddTodoSideEffect
}