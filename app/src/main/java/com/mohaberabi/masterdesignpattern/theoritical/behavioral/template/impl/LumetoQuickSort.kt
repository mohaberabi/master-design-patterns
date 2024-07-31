package com.mohaberabi.masterdesignpattern.theoritical.behavioral.template.impl

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.template.base.QuickSort
import kotlin.random.Random

class LumetoQuickSort : QuickSort() {
    override fun enhance(
        items: MutableList<Int>,
    ) = swap(items.lastIndex, Random.nextInt(items.size), items)

    override fun partition(
        low: Int,
        high: Int,
        items: MutableList<Int>,
    ): Int {

        val pivot = items[items.lastIndex]
        var i = low - 1

        for (j in low..<high) {
            if (items[j] < pivot) {
                i++
                swap(i, j, items)
            }
        }
        swap(i + 1, high, items)
        return i + 1
    }
}