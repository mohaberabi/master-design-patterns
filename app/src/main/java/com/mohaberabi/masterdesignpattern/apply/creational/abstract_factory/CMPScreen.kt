package com.mohaberabi.masterdesignpattern.apply.creational.abstract_factory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mohaberabi.masterdesignpattern.theoritical.creational.abstract_factory.base.KmpUi
import com.mohaberabi.masterdesignpattern.theoritical.creational.abstract_factory.impl.AndroidUi
import com.mohaberabi.masterdesignpattern.theoritical.creational.abstract_factory.impl.IOSUi


enum class Platform {
    Ios,
    Android
}

@Composable
fun CmpScreen(modifier: Modifier = Modifier) {


    var platform by remember {
        mutableStateOf(Platform.Android)
    }

    var expanded by remember {

        mutableStateOf(false)
    }


    var factory: KmpUi = remember {
        AndroidUi()
    }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding()
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Row {

                Text(
                    text = "Current Platform :${platform.name}",
                )


                IconButton(
                    onClick = { expanded = true },
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert, contentDescription = "",
                    )

                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    Platform.entries.forEach { plat ->
                        DropdownMenuItem(
                            text = { Text(text = plat.name) },
                            onClick = {
                                platform = plat
                                factory = when (plat) {
                                    Platform.Ios -> {
                                        IOSUi()
                                    }

                                    Platform.Android -> {
                                        AndroidUi()
                                    }
                                }
                                expanded = false
                            },
                        )
                    }
                }
            }

            factory.button().invoke()
            factory.checkBox().invoke()
        }
    }
}