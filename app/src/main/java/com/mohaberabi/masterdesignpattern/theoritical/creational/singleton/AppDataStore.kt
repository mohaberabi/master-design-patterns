package com.mohaberabi.masterdesignpattern.theoritical.creational.singleton

class AppDataStore private constructor() {


    companion object {
        val instance: AppDataStore = AppDataStore()
    }


    private val data = mutableMapOf<String, String>()


    fun read(key: String): String? = data[key]

    fun write(key: String, value: String) {
        data[key] = value
    }

    fun delete(key: String) = data.remove(key)

    fun clear() = data.clear()
}