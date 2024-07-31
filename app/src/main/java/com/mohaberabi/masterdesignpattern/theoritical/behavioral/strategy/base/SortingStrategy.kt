package com.mohaberabi.masterdesignpattern.theoritical.behavioral.strategy.base

interface SortingStrategy {


    fun sort(data: MutableList<Int>): MutableList<Int>
}