package com.mohaberabi.masterdesignpattern.theoritical.creational.abstract_factory.base

import androidx.compose.runtime.Composable

interface KmpUi {
    @Composable
    fun button(): KmpButton

    @Composable
    fun checkBox(): KmpCheckBox
}