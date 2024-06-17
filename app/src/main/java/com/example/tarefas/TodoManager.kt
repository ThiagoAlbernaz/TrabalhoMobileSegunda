package com.example.tarefas

import java.time.Instant
import java.util.Date

object TodoManager {

    private val todoList = mutableListOf<Todo>()

    fun getAllTodo() : List<Todo>{
        return todoList
    }

    fun adicionarTodo(title : String){
        todoList.add(Todo(System.currentTimeMillis().toInt(),title, Date.from(Instant.now())))
    }

    fun deletarTodo(id : Int){
        todoList.removeIf{
            it.id==id
        }
    }
}