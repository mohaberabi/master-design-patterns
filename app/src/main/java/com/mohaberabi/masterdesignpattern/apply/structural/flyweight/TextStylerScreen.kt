package com.mohaberabi.masterdesignpattern.apply.structural.flyweight

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mohaberabi.masterdesignpattern.theoritical.structural.flyweight.AppTextStylerFactory


data class Todo(
    val data: String,
    val priority: String
)

val notes = listOf(
    Todo("Read Quran", "High"),
    Todo("Clean the house", "Medium"),
    Todo("Buy groceries", "Low"),
    Todo("Read a book", "Low")
)

@Composable
fun TextStylerScreen(modifier: Modifier = Modifier) {


    val appStyler = remember {
        AppTextStylerFactory()
    }


    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(padding)
        ) {
            notes.forEach { todo ->
                val style = appStyler.getStyle(todo.priority)
                style.ApplyStyle(todo.data)
            }
        }
    }


}