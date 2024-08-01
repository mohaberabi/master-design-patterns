package com.mohaberabi.masterdesignpattern.theoritical.behavioral.chain_of_responsiblity.base

data class SupportTicket(

    val title: String,
    val body: String,
    val type: TicketType
)


enum class TicketType {
    General,
    Technical,
    Critical
}
