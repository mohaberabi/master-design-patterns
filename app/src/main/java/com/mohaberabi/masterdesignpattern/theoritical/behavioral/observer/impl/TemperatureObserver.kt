package com.mohaberabi.masterdesignpattern.theoritical.behavioral.observer.impl

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.observer.base.Observer

class TemperatureObserver(
    private val onTemperatureUpdated: (Int?) -> Unit,
) : Observer<Int?> {
    override fun update(state: Int?) {
        onTemperatureUpdated(state)
    }
}