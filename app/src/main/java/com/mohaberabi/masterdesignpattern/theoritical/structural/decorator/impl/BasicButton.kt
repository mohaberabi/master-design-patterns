package com.mohaberabi.masterdesignpattern.theoritical.structural.decorator.impl

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.mohaberabi.masterdesignpattern.theoritical.structural.decorator.base.UIComponent

class BasicButton(
    private val onClick: () -> Unit = {},
    private val label: String = ""
) : UIComponent {
    @Composable
    override fun Render() {
        Button(
            onClick = onClick
        ) {
            Text(text = label)
        }
    }
}