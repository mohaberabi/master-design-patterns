package com.mohaberabi.masterdesignpattern.theoritical.behavioral.chain_of_responsiblity.base

interface SupportHandler {


    fun setNext(support: SupportHandler)


    fun handleRequest(ticket: SupportTicket)
}