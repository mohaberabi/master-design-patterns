package com.mohaberabi.masterdesignpattern.theoritical.behavioral.command.impl

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.command.base.AppCommand


class ThemeChanger {


    private var command: AppCommand? = null


    fun setCommand(command: AppCommand) {
        this.command = command
    }

    fun toggleTheme() {
        command?.execute()
    }
}