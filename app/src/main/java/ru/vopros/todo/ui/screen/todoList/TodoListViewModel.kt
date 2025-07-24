package ru.vopros.todo.ui.screen.todoList

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import ru.vopros.todo.domain.usecase.TodoListUseCase

class TodoListViewModel(
    private val todoListUseCase: TodoListUseCase
) : ViewModel(), ContainerHost<TodoListViewState, TodoListSideEffect> {

    override val container = container<TodoListViewState, TodoListSideEffect>(
        initialState = TodoListViewState(),
        onCreate = {
            reduce { state.copy(isLoading = true) }
            repeatOnSubscription {
                todoListUseCase().collect {
                    reduce {
                        state.copy(
                            isLoading = false,
                            todoList = it
                        )
                    }
                }
            }
        }
    )



}