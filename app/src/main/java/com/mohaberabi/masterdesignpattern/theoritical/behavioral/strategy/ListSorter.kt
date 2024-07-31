package com.mohaberabi.masterdesignpattern.theoritical.behavioral.strategy

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.strategy.base.SortingStrategy


class ListSorter(
    private val strategy: SortingStrategy,
) {
    fun sort(data: List<Int>): List<Int> {
        return strategy.sort(data.toMutableList())

    }
}