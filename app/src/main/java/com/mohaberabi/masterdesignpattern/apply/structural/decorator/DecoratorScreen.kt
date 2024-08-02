package com.mohaberabi.masterdesignpattern.apply.structural.decorator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mohaberabi.masterdesignpattern.theoritical.structural.decorator.impl.BasicButton
import com.mohaberabi.masterdesignpattern.theoritical.structural.decorator.impl.BorderButtonDecorator
import com.mohaberabi.masterdesignpattern.theoritical.structural.decorator.impl.ElevatedButtonDecorator


@Composable
fun DecoratorScreen(modifier: Modifier = Modifier) {
    val button = BasicButton(label = "Button")

    val borderButton = BorderButtonDecorator(button)
    val elevatedButton = ElevatedButtonDecorator(button)
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            button.Render()
            elevatedButton.Render()
            borderButton.Render()
        }
    }
}