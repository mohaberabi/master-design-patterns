package com.mohaberabi.masterdesignpattern.apply.behavioral.observer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.observer.impl.TemperatureObserver
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.observer.impl.TemperatureSubject
import kotlinx.coroutines.delay
import kotlin.random.Random


@Composable
fun TemperatureScreen(
    modifier: Modifier = Modifier,
) {


    var googleTemp by remember {
        mutableIntStateOf(0)
    }
    var appleTemp by remember {
        mutableIntStateOf(0)
    }

    val tempSubject = rememberTemperatureSubject()
    val googleWeather = rememberTemperatureObserver(
        onTemperatureUpdated = {
            googleTemp = it ?: 0
        },
    )
    val appleWeather = rememberTemperatureObserver(
        onTemperatureUpdated = {
            appleTemp = it ?: 0
        },
    )

    LaunchedEffect(
        key1 = Unit,
    ) {
        tempSubject.register(googleWeather)
        tempSubject.register(appleWeather)
    }
    LaunchedEffect(
        key1 = Unit,
    ) {
        repeat(10) {
            tempSubject.update(Random.nextInt(from = 22, until = 60))
            delay(1500L)
        }

    }
    Scaffold(
        modifier = modifier,
    ) { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                text = "Welcome to temperature channel",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            )

            TempRow(
                title = "Apple Weather",
                value = appleTemp,
                onCancel = { tempSubject.remove(appleWeather) }
            )
            Spacer(modifier = Modifier.height(16.dp))

            TempRow(
                title = "Google  Weather",
                value = googleTemp,
                onCancel = { tempSubject.remove(googleWeather) }
            )

        }
    }
}


@Composable
fun TempRow(
    modifier: Modifier = Modifier,
    title: String,
    value: Int,
    onCancel: () -> Unit,
) {
    ListItem(
        modifier = modifier
            .fillMaxWidth(),
        headlineContent = {
            Text(text = "${value}")
        },
        leadingContent = {
            Text(
                text = title,
            )
        },
        trailingContent = {

            TextButton(
                onClick = { onCancel() },
            ) {
                Text(text = "Cancel ")
            }

        }
    )

}

@Composable
fun rememberTemperatureSubject(): TemperatureSubject {
    return remember {
        TemperatureSubject()
    }
}

@Composable
fun rememberTemperatureObserver(
    onTemperatureUpdated: (Int?) -> Unit,
): TemperatureObserver {
    return remember {
        TemperatureObserver(onTemperatureUpdated)
    }
}