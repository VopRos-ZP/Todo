package ru.vopros.todo.data.di

import androidx.room.Room
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.vopros.todo.data.repository.TodoRepositoryImpl
import ru.vopros.todo.data.room.AppDatabase
import ru.vopros.todo.data.room.TodosDao
import ru.vopros.todo.domain.repository.TodoRepository

private val roomModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            context = get(),
            klass = AppDatabase::class.java,
            name = AppDatabase.NAME
        ).build()
    }
    single<TodosDao> { get<AppDatabase>().todosDao }
}

private val repositoryModule = module {
    singleOf(::TodoRepositoryImpl) { bind<TodoRepository>() }
}

internal val dataModule = module {
    includes(
        roomModule,
        repositoryModule
    )
}