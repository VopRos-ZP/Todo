package ru.vopros.todo.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.vopros.todo.data.mapper.fromEntity
import ru.vopros.todo.data.mapper.toEntity
import ru.vopros.todo.data.room.TodosDao
import ru.vopros.todo.data.room.entity.TodoEntity
import ru.vopros.todo.domain.model.Todo
import ru.vopros.todo.domain.repository.TodoRepository

class TodoRepositoryImpl(
    private val todosDao: TodosDao
) : TodoRepository {

    override fun listenAll(): Flow<List<Todo>> {
        return todosDao.listenAll()
            .map { it.map(TodoEntity::fromEntity) }
    }

    override suspend fun add(todo: Todo) {
        todosDao.add(todo.toEntity())
    }

    override suspend fun update(todo: Todo) {
        todosDao.update(todo.toEntity())
    }

    override suspend fun delete(todo: Todo) {
        todosDao.delete(todo.toEntity())
    }
}