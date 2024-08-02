package com.mohaberabi.masterdesignpattern.theoritical.creational.builder.kotlin_way


import kotlin.properties.Delegates

data class KUserPrefsDsl(
    val name: String,
    val lastname: String,
    val email: String,
    val age: Int,
    val orderIds: List<Int>,
    val isMale: Boolean,
    val id: String,
    val lastLoggedInMillis: Long,
) {


    class Builder {
        lateinit var name: String
        lateinit var lastname: String
        lateinit var email: String
        var age by Delegates.notNull<Int>()
        lateinit var orderIds: List<Int>
        var isMale by Delegates.notNull<Boolean>()
        lateinit var id: String
        var lastLoggedInMillis by Delegates.notNull<Long>()


        fun build() = KUserPrefs(
            name = name,
            lastname = lastname,
            age = age,
            email = email,
            isMale = isMale,
            orderIds = orderIds,
            lastLoggedInMillis = lastLoggedInMillis,
            id = id,
        )

    }


}

fun kUserPrefs(
    block: KUserPrefsDsl.Builder.() -> Unit,
): KUserPrefs =
    KUserPrefsDsl.Builder().apply(block).build()




