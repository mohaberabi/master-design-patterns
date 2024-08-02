package com.mohaberabi.masterdesignpattern.theoritical.structural.facade

class CPU {
    fun freeze() {
        println("CPU freezing")
    }

    fun jump(position: Long) {
        println("CPU jumping to position $position")
    }

    fun execute() {
        println("CPU executing")
    }
}

class Memory {
    fun load(position: Long, data: ByteArray) {
        println("Memory loading data at position $position")
    }
}

class Disk {
    fun readData(position: Long, size: Int): ByteArray {
        println("Disk reading data from position $position")
        return ByteArray(size) // Dummy data
    }
}
