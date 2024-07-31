package com.mohaberabi.masterdesignpattern.theoritical.behavioral.template.impl

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.template.base.QuickSort
import kotlin.random.Random

class HoarsQuickSort : QuickSort() {


    override fun partition(
        low: Int,
        high: Int,
        items: MutableList<Int>,
    ): Int {

        val pivot = items[low]


        var i = low - 1
        var j = high + 1
        while (true) {
            do {
                i++
            } while (items[i] <= pivot)
            do {
                j--
            } while (items[j] > pivot)
            if (i >= j) {
                return j
            }
            swap(i, j, items)

        }
    }

    override fun enhance(items: MutableList<Int>) = swap(Random.nextInt(items.size), 0, items)


}