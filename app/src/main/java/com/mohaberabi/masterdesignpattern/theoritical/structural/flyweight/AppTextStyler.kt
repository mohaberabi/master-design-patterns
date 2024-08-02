package com.mohaberabi.masterdesignpattern.theoritical.structural.flyweight

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

interface AppTextStyler {


    @Composable
    fun ApplyStyle(content: String)
}

class DefaultAppTextStyler(
    private val color: Color,
    private val fontWeight: FontWeight
) : AppTextStyler {

    @Composable
    override fun ApplyStyle(content: String) {
        Text(
            text = content,
            fontWeight = fontWeight,
            color = color
        )
    }
}

class AppTextStylerFactory {
    private val styles = mutableMapOf<String, AppTextStyler>()
    fun getStyle(name: String): AppTextStyler {
        return styles.getOrPut(name) {
            when (name) {
                "High" -> DefaultAppTextStyler(Color.Red, FontWeight.Bold)
                "Medium" -> DefaultAppTextStyler(Color.Yellow, FontWeight.Medium)
                "Low" -> DefaultAppTextStyler(Color.Green, FontWeight.Normal)
                else -> DefaultAppTextStyler(Color.Gray, FontWeight.Light)
            }
        }

    }
}