package com.mohaberabi.masterdesignpattern.theoritical.behavioral.state.base

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.state.impl.AppMediaPlayer


enum class MediaPlayerStatus {
    Playing,
    Stopped,
    Paused
}

interface MediaPlayerState {


    val status: MediaPlayerStatus
    fun stop(player: AppMediaPlayer)
    fun play(player: AppMediaPlayer)
    fun pause(player: AppMediaPlayer)

}






