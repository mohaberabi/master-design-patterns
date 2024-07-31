package com.mohaberabi.masterdesignpattern.apply.behavioral.memento

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.memento.TextEditor
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.memento.TextEditorHistory
import com.mohaberabi.masterdesignpattern.ui.theme.MasterDesignPatternTheme


@Composable
fun BlogScreen(
    modifier: Modifier = Modifier,
) {


    var blog by remember {

        mutableStateOf("")
    }

    var textValue by remember {

        mutableStateOf("")
    }
    val history = rememberTextEditorHistory()
    val editor = rememberTextEditor()
    Scaffold { padding ->
        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
        ) {


            TextField(
                value = textValue,
                modifier = Modifier.fillMaxWidth(),
                suffix = {
                    Row {

                        TextButton(
                            onClick = {
                                editor.write(textValue)
                                history.save(editor.save())
                                blog = editor.data()
                            },
                        ) {
                            Text(text = "Save")
                        }

                        if (blog.isNotEmpty())
                            TextButton(
                                onClick = {
                                    history.undo()?.let {
                                        editor.restore(it)
                                        blog = editor.data()
                                    }?:run {
                                        blog = ""
                                    }

                                },
                            ) {
                                Text(text = "Undo")
                            }
                    }
                },
                onValueChange = { textValue = it },
                label = { Text(text = "Write a blog") },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Blue,
                )
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Card(
                modifier = Modifier.fillMaxSize(),
            ) {

                Text(
                    modifier = Modifier.padding(8.dp),
                    text = blog,
                )
            }
        }

    }
}


@Preview(
    showBackground = true,
)
@Composable
private fun PreviewBlogScreen() {

    MasterDesignPatternTheme {
        BlogScreen()
    }
}

@Composable
private fun rememberTextEditor(): TextEditor {
    return remember {
        TextEditor()
    }
}

@Composable
private fun rememberTextEditorHistory(): TextEditorHistory {
    return remember {
        TextEditorHistory()
    }
}