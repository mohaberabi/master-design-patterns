package com.mohaberabi.masterdesignpattern.theoritical.behavioral.state.impl

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.state.base.MediaPlayerState
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.state.base.MediaPlayerStatus

class PlayingState : MediaPlayerState {
    override fun stop(player: AppMediaPlayer) = player.setState(StoppedState())


    override fun play(player: AppMediaPlayer) {}

    override fun pause(player: AppMediaPlayer) = player.setState(PausedState())

    override val status: MediaPlayerStatus
        get() = MediaPlayerStatus.Playing
}


class StoppedState : MediaPlayerState {
    override fun stop(player: AppMediaPlayer) {}


    override fun play(player: AppMediaPlayer) = player.setState(PlayingState())

    override fun pause(player: AppMediaPlayer) = player.setState(PausedState())
    override val status: MediaPlayerStatus
        get() = MediaPlayerStatus.Stopped
}

class PausedState : MediaPlayerState {
    override fun stop(player: AppMediaPlayer) = player.setState(StoppedState())


    override fun play(player: AppMediaPlayer) = player.setState(PlayingState())

    override fun pause(player: AppMediaPlayer) {}
    override val status: MediaPlayerStatus
        get() = MediaPlayerStatus.Paused
}