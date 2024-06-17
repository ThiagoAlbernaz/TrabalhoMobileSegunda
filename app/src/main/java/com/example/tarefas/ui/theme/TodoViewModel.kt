package com.example.tarefas.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tarefas.Todo
import com.example.tarefas.TodoManager

class TodoViewModel : ViewModel() {

    private var _todoList = MutableLiveData<List<Todo>>()
    val todoList : LiveData<List<Todo>> = _todoList

    fun getAllTodo(){
        _todoList.value = TodoManager.getAllTodo().reversed()
    }

    fun adicionarTodo(title : String){
        TodoManager.adicionarTodo(title)
        getAllTodo()
    }

    fun deletarTodo(id : Int){
        TodoManager.deletarTodo(id)
        getAllTodo()
    }
}

