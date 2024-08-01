package com.mohaberabi.masterdesignpattern.theoritical.behavioral.command.impl


enum class AppThemeType {
    Light, Dark,

}

class AppTheme {

    var type: AppThemeType = AppThemeType.Light
    fun setTheme(type: AppThemeType) {
        this.type = type
    }
}