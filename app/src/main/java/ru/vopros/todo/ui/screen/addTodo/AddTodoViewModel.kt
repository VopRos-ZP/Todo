package ru.vopros.todo.ui.screen.addTodo

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.blockingIntent
import org.orbitmvi.orbit.viewmodel.container
import ru.vopros.todo.domain.model.Priority
import ru.vopros.todo.domain.model.Todo
import ru.vopros.todo.domain.usecase.AddTodoUseCase
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@OptIn(OrbitExperimental::class)
class AddTodoViewModel(
    private val addTodoUseCase: AddTodoUseCase,
) : ViewModel(), ContainerHost<AddTodoViewState, AddTodoSideEffect> {

    override val container = container<AddTodoViewState, AddTodoSideEffect>(
        initialState = AddTodoViewState()
    )

    fun onBackClick() = intent {
        postOnBackClick()
    }

    fun onTitleChange(value: String) = blockingIntent {
        reduce { state.copy(title = value) }
    }

    fun onDataChange(value: String) = blockingIntent {
        reduce { state.copy(data = value) }
    }

    fun onPriorityChange(value: Priority) = intent {
        reduce { state.copy(priority = value) }
    }

    fun onSaveClick() = intent {
        reduce { state.copy(isLoading = true) }
        try {
            val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            sdf.timeZone = TimeZone.getDefault()

            val todo = Todo(
                id = 0,
                title = state.title,
                data = state.data,
                priority = state.priority,
                isActive = false,
                createdAt = sdf.format(Date()),
                updatedAt = null
            )
            addTodoUseCase(todo)
            reduce { state.copy(isLoading = false) }
            postOnBackClick()
        } catch (e: Exception) {
            e.printStackTrace()
            //TODO: Show error on Screen
        }
    }

    private suspend fun postOnBackClick() = subIntent {
        postSideEffect(AddTodoSideEffect.OnBackClick)
    }


}