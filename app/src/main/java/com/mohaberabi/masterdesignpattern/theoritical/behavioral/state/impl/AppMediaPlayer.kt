package com.mohaberabi.masterdesignpattern.theoritical.behavioral.state.impl

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.state.base.MediaPlayerState

class AppMediaPlayer {

    private var state: MediaPlayerState = StoppedState()
    val status get() = state.status

    fun setState(state: MediaPlayerState) {
        this.state = state
    }

    fun play() = state.play(this)
    fun stop() = state.stop(this)
    fun pause() = state.pause(this)
}