package com.example.tarefas

import java.time.Instant
import java.util.Date

data class Todo(
    var id: Int,
    var title: String,
    var createdAt: Date
)


fun getFakeTodo() : List<Todo>{
    return listOf<Todo>(
        Todo(id = 1, title = "Primeira tarefa", Date.from(Instant.now())),
        Todo(id = 2, title = "Segunda tarefa", Date.from(Instant.now())),
        Todo(id = 3, title = "Terceira tarefa", Date.from(Instant.now())),
        Todo(id = 4, title = "Quarta tarefa", Date.from(Instant.now()))

    )
}
