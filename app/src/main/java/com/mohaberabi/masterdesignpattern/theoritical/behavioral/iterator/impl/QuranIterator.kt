package com.mohaberabi.masterdesignpattern.theoritical.behavioral.iterator.impl

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.iterator.base.AppIterator
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.iterator.base.IteratorAggregator


class QuranIterator(
    private val qurans: List<Quran>
) : AppIterator<Quran> {
    private var position: Int = 0
    override fun hasNext(): Boolean = position < qurans.size
    override fun next(): Quran = qurans[position++]
}


class QuranIteratorAggregator(
    private val qurans: List<Quran>
) : IteratorAggregator<Quran> {
    override fun create(): AppIterator<Quran> {
        return QuranIterator(qurans)
    }
}