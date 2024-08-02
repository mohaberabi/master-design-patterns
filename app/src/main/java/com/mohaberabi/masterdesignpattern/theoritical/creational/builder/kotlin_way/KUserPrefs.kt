package com.mohaberabi.masterdesignpattern.theoritical.creational.builder.kotlin_way


import kotlin.properties.Delegates


data class KUserPrefs(
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
        private lateinit var name: String
        private lateinit var lastname: String
        private lateinit var email: String
        private var age by Delegates.notNull<Int>()
        private lateinit var orderIds: List<Int>
        private var isMale by Delegates.notNull<Boolean>()
        private lateinit var id: String
        private var lastLoggedInMillis by Delegates.notNull<Long>()


        fun name(name: String) = apply { this.name = name }
        fun lastname(lastname: String) = apply { this.lastname = lastname }
        fun age(age: Int) = apply { this.age = age }
        fun email(email: String) = apply { this.email = email }
        fun orderIds(orderIds: List<Int>) = apply { this.orderIds = orderIds }
        fun gender(isMale: Boolean) = apply { this.isMale = isMale }
        fun id(id: String) = apply { this.id = id }
        fun lastLoggedMillis(lastLoggedMillis: Long) =
            apply { this.lastLoggedInMillis = lastLoggedMillis }

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




