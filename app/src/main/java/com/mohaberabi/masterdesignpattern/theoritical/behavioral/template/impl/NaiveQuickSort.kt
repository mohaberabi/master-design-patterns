package com.mohaberabi.masterdesignpattern.theoritical.behavioral.template.impl

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.template.base.QuickSort
import kotlin.random.Random

class NaiveQuickSort : QuickSort() {
    override fun enhance(
        items: MutableList<Int>,
    ) = swap(0, Random.nextInt(items.size - 1), items)

    override fun partition(
        low: Int,
        high: Int,
        items: MutableList<Int>,
    ): Int {

        val pivot = items[low]
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()

        for (i in low + 1..high) {
            if (items[i] <= pivot) {
                left.add(items[i])
            } else {
                right.add(items[i])
            }
        }

        var index = low
        for (item in left) {
            items[index] = item
            index++
        }
        val partitionIndex = index
        items[index] = pivot
        index++
        for (item in right) {
            items[index] = item
            index++
        }

        return partitionIndex
    }
}