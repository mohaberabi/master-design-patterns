package com.mohaberabi.masterdesignpattern.theoritical.creational.abstract_factory.impl

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mohaberabi.masterdesignpattern.theoritical.creational.abstract_factory.base.KmpCheckBox

class CmpIosCheckBox : KmpCheckBox {
    @Composable
    override operator fun invoke() {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {

            Text(text = "Iam Ios CheckBox")
            Checkbox(
                checked = true,
                onCheckedChange = {},
            )
        }
    }
}

class CmpAndroidCheckBox : KmpCheckBox {
    @Composable
    override operator fun invoke() {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {

            Text(text = "Iam Android CheckBox")
            Checkbox(
                checked = true,
                onCheckedChange = {},
            )
        }
    }
}