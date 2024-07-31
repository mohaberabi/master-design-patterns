package com.mohaberabi.masterdesignpattern.theoritical.behavioral.observer.base

interface Subject<T> {

    fun register(observer: Observer<T?>)
    fun remove(observer: Observer<T?>)
    fun update(t: T?)

    fun dispose()
}