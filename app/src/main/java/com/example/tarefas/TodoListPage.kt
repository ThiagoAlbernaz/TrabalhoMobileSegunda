package com.example.tarefas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarefas.ui.theme.TodoViewModel

@Composable
fun TodoListPage(viewModel: TodoViewModel){
    
    val todoList by viewModel.todoList.observeAsState()
    var inputText by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            OutlinedTextField(modifier = Modifier.weight(1f),value = inputText,
                onValueChange = {
                inputText = it
            })
            Button(onClick = {
                viewModel.adicionarTodo(inputText)
                inputText = ""
            }) { Text(text = "Adicionar")
            }
        }
        
        todoList?.let {
            LazyColumn(
                content = {
                    itemsIndexed(it){ index: Int, item: Todo ->
                        TodoItem(item = item, onDelete = {
                            viewModel.deletarTodo(item.id)
                        })
                    }
                }
            )
        }?: Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "Sem items",
            fontSize = 16.sp)
        
        

        }
    }

@Composable
fun TodoItem(item : Todo,onDelete : ()->Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.Blue)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = item.createdAt.toString(),
                fontSize = 12.sp,
                color = Color.LightGray
            )
            Text(text = item.title,
                fontSize = 20.sp,
                color = Color.White)
        }
        IconButton(onClick = onDelete) {
            Icon(painter = painterResource(id = R.drawable.baseline_delete_outline_24),
                contentDescription = "Deletar",
                tint = Color.White)
        }
    }
}