package ru.vopros.todo.domain.model

data class Todo(
    val id: Int,
    val title: String,
    val data: String,
    val priority: Priority,
    val isActive: Boolean,
    val createdAt: String,
    val updatedAt: String?
)
