package ru.vopros.todo.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.vopros.todo.domain.model.Todo

interface TodoRepository {

    fun listenAll(): Flow<List<Todo>>

    suspend fun add(todo: Todo)

    suspend fun update(todo: Todo)

    suspend fun delete(todo: Todo)

}