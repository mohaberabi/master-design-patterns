package com.mohaberabi.masterdesignpattern.theoritical.structural.adapter

data class MessageModel(
    val message: String,
    val sentAtMillis: Long
)

data class PlainMessage(
    val raw: String
)