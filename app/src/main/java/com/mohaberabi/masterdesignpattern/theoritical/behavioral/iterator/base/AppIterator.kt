package com.mohaberabi.masterdesignpattern.theoritical.behavioral.iterator.base


interface AppIterator<T> {
    fun hasNext(): Boolean
    fun next(): T
}


interface IteratorAggregator<T> {
    fun create(): AppIterator<T>
}