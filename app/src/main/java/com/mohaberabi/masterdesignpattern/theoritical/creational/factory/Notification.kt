package com.mohaberabi.masterdesignpattern.theoritical.creational.factory


interface AppNotification {


    fun notify()
}


class PushNotification : AppNotification {
    override fun notify() {
        println("Push Noti ")
    }
}

class InAppNotification : AppNotification {
    override fun notify() {
        print("App Noti")
    }
}

class EmailNotification : AppNotification {
    override fun notify() {
        println("Email Noti")
    }
}