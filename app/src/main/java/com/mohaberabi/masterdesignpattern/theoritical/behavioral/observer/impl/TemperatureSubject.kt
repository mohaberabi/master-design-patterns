package com.mohaberabi.masterdesignpattern.theoritical.behavioral.observer.impl

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.observer.base.Observer
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.observer.base.Subject

class TemperatureSubject : Subject<Int?> {

    private var temperature: Int? = 0
    private var observers: MutableList<Observer<Int?>> = mutableListOf()


    private fun notifyCurrentObserver() {
        observers.forEach {
            it.update(temperature)
        }
    }

    override fun register(observer: Observer<Int?>) {
        if (!observers.contains(observer)) {
            observers.add(observer)
        }
    }

    override fun remove(observer: Observer<Int?>) {
        if (observers.contains(observer)) {
            observers.remove(observer)
        }
    }

    override fun update(t: Int?) {
        temperature = t
        notifyCurrentObserver()
    }

    override fun dispose() {
        observers = mutableListOf()
        temperature = null
    }

}