package com.mohaberabi.masterdesignpattern.apply.structural.composite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mohaberabi.masterdesignpattern.theoritical.structural.composite.ComposableButton
import com.mohaberabi.masterdesignpattern.theoritical.structural.composite.ComposableColumn
import com.mohaberabi.masterdesignpattern.theoritical.structural.composite.ComposableText


@Composable
fun ComposeAbleScreen(modifier: Modifier = Modifier) {


    val column = ComposableColumn()

    val button = ComposableButton()
    val text = ComposableText()

    column.apply {
        add(button)
        add(text)
    }
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            column.Compose()
        }
    }
}