package com.mohaberabi.masterdesignpattern.theoritical.behavioral.strategy.impl

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.strategy.base.SortingStrategy

class MergeSortSortingStrategy : SortingStrategy {
    override fun sort(data: MutableList<Int>): MutableList<Int> {
        mergeSort(data)
        return data
    }


    private fun mergeSort(
        data: MutableList<Int>,
        low: Int = 0,
        high: Int = data.size - 1
    ) {
        if (low < high) {

            val mid = (low + high) / 2
            mergeSort(data = data, low = low, high = mid)
            mergeSort(data = data, low = mid + 1, high = high)
            merge(low = low, mid = mid, high = high, list = data)
        }

    }

    private fun merge(
        low: Int,
        mid: Int,
        high: Int,
        list: MutableList<Int>
    ) {

        val leftSize = mid - low + 1
        val rightSize = high - mid
        val left = mutableListOf<Int>(leftSize)
        val right = mutableListOf<Int>()

        for (i in 0 until leftSize) {
            left[i] = list[low + i]
        }
        for (i in 0 until rightSize) {
            right[i] = list[mid + 1 + i]
        }
        var i = 0
        var j = 0
        var index = low
        while (i < leftSize && j < rightSize) {

            if (left[i] <= right[j]) {
                list[index++] = left[i++]
            } else {
                list[index++] = right[j++]

            }
        }


        while (i < leftSize) {
            list[index++] = left[i++]

        }
        while (j < rightSize) {
            list[index++] = right[j++]
        }
    }
}