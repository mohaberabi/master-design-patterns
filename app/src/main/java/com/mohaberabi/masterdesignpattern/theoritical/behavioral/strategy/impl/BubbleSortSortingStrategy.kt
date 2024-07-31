package com.mohaberabi.masterdesignpattern.theoritical.behavioral.strategy.impl

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.strategy.base.SortingStrategy

class BubbleSortSortingStrategy : SortingStrategy {
    override fun sort(
        data: MutableList<Int>,
    ): MutableList<Int> {
        val n = data.size
        for (i in 0..<n - 1) {
            var swapped = false
            for (j in 0..<n - 1) {
                if (data[j + 1] < data[j]) {
                    swapped = true
                    swap(j, j + 1, data)
                }
            }
            if (!swapped) {
                return data
            }
        }
        return data

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