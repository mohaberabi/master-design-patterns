package com.mohaberabi.masterdesignpattern.theoritical.structural.composite

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

interface ComposeAble {

    @Composable
    fun Compose()
}


class ComposableButton(
    private val content: ComposeAble = ComposableText("I am a tree node acting as button"),
    private val onClick: () -> Unit = {}
) : ComposeAble {
    @Composable
    override fun Compose() {
        Button(
            onClick,
        ) {
            content.Compose()
        }
    }
}

class ComposableText(
    private val text: String = "I am a tree node acting as text"
) : ComposeAble {
    @Composable
    override fun Compose() {
        Text(
            text
        )
    }

}

class ComposableColumn : ComposeAble {
    private var composables = mutableListOf<ComposeAble>()


    fun add(composable: ComposeAble) {
        composables.add(composable)
    }

    fun remove(composable: ComposeAble) {
        composables.remove(composable)
    }

    @Composable
    override fun Compose() {
        Column {
            composables.forEach { it.Compose() }
        }
    }
}