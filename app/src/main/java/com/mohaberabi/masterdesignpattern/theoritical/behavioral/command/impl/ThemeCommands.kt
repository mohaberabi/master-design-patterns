package com.mohaberabi.masterdesignpattern.theoritical.behavioral.command.impl

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.command.base.AppCommand


class DarkThemeCommand(
    private val theme: AppTheme,
) : AppCommand {
    override fun execute() {
        theme.setTheme(AppThemeType.Dark)
    }

}


class LightThemeCommand(
    private val theme: AppTheme,
) : AppCommand {
    override fun execute() {
        theme.setTheme(AppThemeType.Light)

    }
}