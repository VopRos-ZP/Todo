package ru.vopros.todo.data.mapper

import ru.vopros.todo.data.room.entity.TodoEntity
import ru.vopros.todo.domain.model.Priority
import ru.vopros.todo.domain.model.Todo
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

fun TodoEntity.fromEntity(): Todo = Todo(
    id = id,
    title = title,
    data = data,
    priority = Priority.valueOf(priority),
    isActive = isActive,
    createdAt = convertTimestampToTime(createdAt),
    updatedAt = updatedAt?.let { convertTimestampToTime(it) },
)

fun Todo.toEntity(): TodoEntity = TodoEntity(
    id = id,
    title = title,
    data = data,
    priority = priority.name,
    isActive = isActive,
    createdAt = convertTimeToTimestamp(createdAt),
    updatedAt = updatedAt?.let { convertTimeToTimestamp(it) },
)

private const val PATTERN = "HH:mm:ss"

private fun convertTimestampToTime(timestamp: Long): String {
    val stamp = Timestamp(timestamp * 1000)
    val date = Date(stamp.time)
    val sdf = SimpleDateFormat(PATTERN, Locale.getDefault())
    sdf.timeZone = TimeZone.getDefault()
    return sdf.format(date)
}

private fun convertTimeToTimestamp(format: String): Long {
    val sdf = SimpleDateFormat(PATTERN, Locale.getDefault())
    sdf.timeZone = TimeZone.getDefault()
    return sdf.parse(format)!!.time
}