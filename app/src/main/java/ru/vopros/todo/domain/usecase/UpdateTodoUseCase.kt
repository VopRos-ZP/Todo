package ru.vopros.todo.domain.usecase

import ru.vopros.todo.domain.model.Todo
import ru.vopros.todo.domain.repository.TodoRepository

class UpdateTodoUseCase(
    private val todoRepository: TodoRepository
) {

    suspend operator fun invoke(todo: Todo) = todoRepository.update(todo)

}