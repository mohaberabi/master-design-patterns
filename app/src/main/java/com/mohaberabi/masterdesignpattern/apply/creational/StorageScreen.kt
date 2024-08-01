package com.mohaberabi.masterdesignpattern.apply.creational

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mohaberabi.masterdesignpattern.theoritical.creational.singleton.AppDataStore


@Composable
fun StorageScreen(
    modifier: Modifier = Modifier,
) {


    val dataStore = remember {
        AppDataStore.instance
    }

    var key by remember {
        mutableStateOf("")
    }
    var value by remember {

        mutableStateOf("")
    }
    var result by remember {

        mutableStateOf("")
    }
    Scaffold {


            padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
        ) {


            Text(text = "Save your data")


            OutlinedTextField(
                label = {
                    Text(text = "Key")
                },
                value = key,
                onValueChange = { key = it },
            )
            OutlinedTextField(
                label = {
                    Text(text = "Value")
                },
                value = value,
                onValueChange = { value = it },
            )
            Button(
                onClick = {
                    dataStore.write(key, value)
                    result = dataStore.read(key) ?: ""
                },
            ) {
                Text(
                    text = "Save",
                )
            }

            if (result.isNotEmpty()) {
                Text(text = "Your ${key} has value of :${result}")

            }

        }
    }
}



