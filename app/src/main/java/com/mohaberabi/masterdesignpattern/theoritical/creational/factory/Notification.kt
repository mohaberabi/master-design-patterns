package com.mohaberabi.masterdesignpattern.theoritical.creational.factory


interface AppNotification {


    fun sendNotification()
}


class PushNotification : AppNotification {
    override fun sendNotification() {
        println("Push Noti ")
    }
}

class InAppNotification : AppNotification {
    override fun sendNotification() {
        print("App Noti")
    }
}

class EmailNotification : AppNotification {
    override fun sendNotification() {
        println("Email Noti")
    }
}