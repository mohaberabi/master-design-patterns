package com.mohaberabi.masterdesignpattern.theoritical.creational.factory

import android.provider.ContactsContract.CommonDataKinds.Email

interface NotificationFactory {

    fun create(): AppNotification
}


class PushNotificationFactory : NotificationFactory {
    override fun create(): AppNotification = PushNotification()
}

class InAppNotificationFactory : NotificationFactory {
    override fun create(): AppNotification = InAppNotification()
}

class EmailNotificationFactory : NotificationFactory {
    override fun create(): AppNotification = EmailNotification()
}