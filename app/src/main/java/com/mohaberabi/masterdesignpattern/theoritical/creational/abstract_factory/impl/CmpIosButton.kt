package com.mohaberabi.masterdesignpattern.theoritical.creational.abstract_factory.impl

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.mohaberabi.masterdesignpattern.theoritical.creational.abstract_factory.base.KmpButton


class CmpIosButton : KmpButton {
    @Composable
    override operator fun invoke() {

        Button(
            onClick = {},
        ) {
            Text(text = "Iam IOS Button ")
        }
    }

}

class CmpAndroidButton : KmpButton {
    @Composable
    override operator fun invoke() {

        Button(onClick = {}) {
            Text(text = "Iam Android Button ")
        }
    }
}
