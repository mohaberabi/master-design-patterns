package com.mohaberabi.masterdesignpattern.theoritical.structural.adapter

class DefaultChatService(
    private val onMessageSent: (MessageModel) -> Unit = {}
) : ChatService {
    override fun sendMessage(
        message: MessageModel,
    ) = onMessageSent(message)

}

class PlainChatService(
    private val plain: PlainMessage,
    private val onMessageSent: (MessageModel) -> Unit = {},
    private val onError: () -> Unit = {}
) : ChatService {
    override fun sendMessage(message: MessageModel) {
        val parts = plain.raw.split("|")
        if (parts.size == 2) {
            val text = parts[0]
            val time = parts[1].toLong()
            val messageModel = MessageModel(text, time)
            onMessageSent(messageModel)
        } else {
            onError()
        }
    }
}