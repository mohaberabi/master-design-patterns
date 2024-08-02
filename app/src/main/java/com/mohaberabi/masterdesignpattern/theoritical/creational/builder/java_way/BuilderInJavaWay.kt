package com.mohaberabi.masterdesignpattern.theoritical.creational.builder.java_way


data class UserPrefs(
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
        private var name: String = ""
        private var lastname: String = ""
        private var email: String = ""
        private var age = 0
        private var orderIds = mutableListOf<Int>()
        private var isMale = false
        private var id: String = ""
        private var lastLoggedInMillis = 0L
        fun setName(name: String): Builder {
            this.name = name
            return this
        }

        fun setLastName(lname: String): Builder {
            this.lastname = lname
            return this
        }

        fun setEmail(email: String): Builder {
            this.email = email
            return this
        }

        fun setAge(age: Int): Builder {
            this.age = age
            return this
        }

        fun setGender(isMale: Boolean): Builder {
            this.isMale = isMale
            return this
        }

        fun addOrderId(id: Int): Builder {
            orderIds.add(id)
            return this
        }

        fun setOrderId(id: String): Builder {
            this.id = id
            return this
        }

        fun setLastLoggedIn(last: Long): Builder {
            this.lastLoggedInMillis = last
            return this
        }

        fun build(): UserPrefs = UserPrefs(
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