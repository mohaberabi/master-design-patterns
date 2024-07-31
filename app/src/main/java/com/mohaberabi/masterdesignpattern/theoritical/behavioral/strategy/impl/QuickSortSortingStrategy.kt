package com.mohaberabi.masterdesignpattern.theoritical.behavioral.strategy.impl

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.strategy.base.SortingStrategy

class QuickSortSortingStrategy : SortingStrategy {
    override fun sort(
        data: MutableList<Int>,
    ): MutableList<Int> {

        quickSort(
            data = data
        )
        return data
    }

    private fun quickSort(
        low: Int = 0,
        data: MutableList<Int>,
        high: Int = data.size - 1,
    ) {

        if (high > low) {
            val piviot = hoars(
                data = data,
                low = low,
                high = high
            )
            quickSort(
                low,
                data,
                piviot,
            )
            quickSort(
                piviot + 1,
                data,
                high,
            )
        }
    }


    private fun hoars(
        data: MutableList<Int>,
        low: Int,
        high: Int,
    ): Int {
        var i = low - 1
        var j = high + 1
        val pivot = data[low]
        while (true) {
            do {
                i++
            } while (data[i] < pivot)

            do {
                j--
            } while (data[j] > pivot)

            if (i >= j) {
                return j
            }
            swap(i, j, data)

        }

    }

    private fun swap(
        i: Int,
        j: Int,
        list: MutableList<Int>,
    ) {
        val temp = list[i]
        list[i] = list[j]
        list[j] = temp

    }
}