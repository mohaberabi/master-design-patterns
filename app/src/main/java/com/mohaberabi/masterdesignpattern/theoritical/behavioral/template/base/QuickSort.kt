package com.mohaberabi.masterdesignpattern.theoritical.behavioral.template.base

abstract class QuickSort {


    fun quickSort(
        items: MutableList<Int>,
    ): List<Int> {
        enhance(items)
        quickSort(
            items = items,
            low = 0,
            high = items.size - 1
        )
        return items
    }

    private fun quickSort(
        low: Int,
        high: Int,
        items: MutableList<Int>,
    ) {

        if (low < high) {
            val pivot = partition(
                low = low,
                high = high,
                items = items,
            )
            quickSort(
                low = low,
                high = pivot,
                items = items,
            )
            quickSort(
                low = pivot + 1,
                high = high,
                items = items,
            )

        }
    }

    protected abstract fun enhance(items: MutableList<Int>)
    protected abstract fun partition(
        low: Int,
        high: Int,
        items: MutableList<Int>,
    ): Int

    protected fun swap(i: Int, j: Int, items: MutableList<Int>) {
        val temp = items[i]
        items[i] = items[j]
        items[j] = temp
    }
}