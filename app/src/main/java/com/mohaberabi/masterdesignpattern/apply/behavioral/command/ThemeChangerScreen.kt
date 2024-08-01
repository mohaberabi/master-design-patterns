package com.mohaberabi.masterdesignpattern.apply.behavioral.command

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.command.impl.AppTheme
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.command.impl.AppThemeType
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.command.impl.DarkThemeCommand
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.command.impl.LightThemeCommand
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.command.impl.ThemeChanger


@Composable
fun ThemeChangerScreen(
    modifier: Modifier = Modifier,
) {


    val appTheme = remember {
        AppTheme()
    }
    val lightTheme = remember {
        LightThemeCommand(appTheme)
    }
    val darkTheme = remember {
        DarkThemeCommand(appTheme)
    }
    val themeChanger = remember {
        ThemeChanger()
    }
    var currentTheme by remember {
        mutableStateOf(appTheme.type)
    }
    Scaffold { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {


            Text(text = "Choose Your Theme")

            AppThemeType.entries.forEach { theme ->

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {

                    Text(text = theme.name)

                    RadioButton(
                        selected = theme == currentTheme,
                        onClick = {
                            when (theme) {
                                AppThemeType.Light -> {
                                    themeChanger.setCommand(lightTheme)
                                }

                                AppThemeType.Dark -> {
                                    themeChanger.setCommand(darkTheme)
                                }
                            }
                            themeChanger.toggleTheme()

                            currentTheme = appTheme.type
                        },
                    )
                }

            }
        }
    }
}








