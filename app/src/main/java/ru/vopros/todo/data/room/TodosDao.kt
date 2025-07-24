package ru.vopros.todo.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.vopros.todo.data.room.entity.TodoEntity

@Dao
interface TodosDao {

    @Query("SELECT * FROM todos")
    fun listenAll(): Flow<List<TodoEntity>>

    @Insert
    suspend fun add(entity: TodoEntity)

    @Update
    suspend fun update(entity: TodoEntity)

    @Delete
    suspend fun delete(entity: TodoEntity)

}