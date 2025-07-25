package ru.vopros.todo.ui.screen.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.vopros.todo.ui.screen.AddTodo
import ru.vopros.todo.ui.screen.TodoList
import ru.vopros.todo.ui.screen.addTodo.AddTodoScreen
import ru.vopros.todo.ui.screen.todoList.TodoListScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = TodoList
    ) {
        composable<TodoList> {
            TodoListScreen(
                onAddClick = {
                    navController.navigate(AddTodo)
                }
            )
        }
        composable<AddTodo> {
            AddTodoScreen(
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
    }
}