package com.mohaberabi.masterdesignpattern.apply.behavioral.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.state.base.MediaPlayerState
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.state.base.MediaPlayerStatus
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.state.impl.AppMediaPlayer


@Composable
fun MediaPlayerScreen(
    modifier: Modifier = Modifier,
) {


    val player = rememberMediaPlayer()
    var status by remember {
        mutableStateOf(player.status)
    }

    Scaffold { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding()
                .padding(16.dp)
        ) {


            Text(
                text = "You Are Currently ${status.name}",
                textAlign = TextAlign.Center,
            )
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextButton(onClick = {
                    player.pause()
                    status = player.status
                }) {

                    Text(text = "Pause")
                }
                IconButton(onClick = {
                    player.play()
                    status = player.status
                }) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "",
                    )
                }
                TextButton(onClick = {
                    player.stop()
                    status = player.status
                }) {

                    Text(text = "Stop")
                }
            }
        }
    }
}


@Composable
fun rememberMediaPlayer(): AppMediaPlayer {
    return remember {
        AppMediaPlayer()
    }
}