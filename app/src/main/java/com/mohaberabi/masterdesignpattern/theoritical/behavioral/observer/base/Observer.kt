package com.mohaberabi.masterdesignpattern.theoritical.behavioral.observer.base

interface Observer<T> {
    fun update(state: T?)
}