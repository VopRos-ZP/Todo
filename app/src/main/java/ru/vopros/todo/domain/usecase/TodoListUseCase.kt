package ru.vopros.todo.domain.usecase

import ru.vopros.todo.domain.repository.TodoRepository

class TodoListUseCase(
    private val todoRepository: TodoRepository
) {

    operator fun invoke() = todoRepository.listenAll()

}