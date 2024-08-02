package com.mohaberabi.masterdesignpattern.theoritical.structural.decorator.impl

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mohaberabi.masterdesignpattern.theoritical.structural.decorator.base.UIComponent
import com.mohaberabi.masterdesignpattern.theoritical.structural.decorator.base.UIComponentDecorator


class BorderButtonDecorator(
    uiComponent: UIComponent,
    val value: Dp = 2.dp,
    val color: Color = Color.Black
) : UIComponentDecorator(uiComponent) {

    @Composable
    override fun Render() {
        Box(
            modifier = Modifier
                .border(value, color)
                .padding(4.dp),
        ) {
            uiComponent.Render()
        }
    }
}

class ElevatedButtonDecorator(
    uiComponent: UIComponent,
    val value: Dp = 20.dp
) : UIComponentDecorator(uiComponent) {
    @Composable
    override fun Render() {
        Box(
            modifier = Modifier
                .shadow(value)
        ) {
            uiComponent.Render()
        }
    }
}