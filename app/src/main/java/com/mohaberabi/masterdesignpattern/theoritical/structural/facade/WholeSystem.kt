package com.mohaberabi.masterdesignpattern.theoritical.structural.facade

class MyComputer(
    private val cpu: CPU,
    private val memory: Memory,
    private val disk: Disk,
) {


    fun startComputer() {
        cpu.freeze()
        memory.load(0, disk.readData(0, 1024))
        cpu.jump(0)
        cpu.execute()
    }
}