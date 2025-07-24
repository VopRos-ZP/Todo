package ru.vopros.todo.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.vopros.todo.data.room.entity.TodoEntity

@Database(
    version = 1,
    entities = [TodoEntity::class],
)
abstract class AppDatabase : RoomDatabase() {

    abstract val todosDao: TodosDao

    companion object {
        const val NAME = "AppDatabase"
    }

}