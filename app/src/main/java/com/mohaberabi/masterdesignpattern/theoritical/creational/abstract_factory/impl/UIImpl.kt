package com.mohaberabi.masterdesignpattern.theoritical.creational.abstract_factory.impl

import androidx.compose.runtime.Composable
import com.mohaberabi.masterdesignpattern.theoritical.creational.abstract_factory.base.KmpButton
import com.mohaberabi.masterdesignpattern.theoritical.creational.abstract_factory.base.KmpCheckBox
import com.mohaberabi.masterdesignpattern.theoritical.creational.abstract_factory.base.KmpUi


class AndroidUi : KmpUi {
    @Composable

    override fun button(): KmpButton = CmpAndroidButton()

    @Composable
    override fun checkBox(): KmpCheckBox = CmpAndroidCheckBox()
}


class IOSUi : KmpUi {
    @Composable

    override fun button(): KmpButton = CmpIosButton()

    @Composable
    override fun checkBox(): KmpCheckBox = CmpIosCheckBox()
}
