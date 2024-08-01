package com.mohaberabi.masterdesignpattern.theoritical.behavioral.chain_of_responsiblity.impl

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.chain_of_responsiblity.base.SupportHandler
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.chain_of_responsiblity.base.SupportTicket
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.chain_of_responsiblity.base.TicketType

class GeneralSupportHandler(
    private val onHandle: () -> Unit = {}
) : SupportHandler {
    private var next: SupportHandler? = null
    override fun setNext(
        support: SupportHandler,
    ) {
        next = support
    }

    override fun handleRequest(
        ticket: SupportTicket,
    ) {
        if (ticket.type == TicketType.General) {
            onHandle.invoke()
        } else {
            next?.handleRequest(ticket)
        }
    }
}