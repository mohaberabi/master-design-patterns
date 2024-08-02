package com.mohaberabi.masterdesignpattern

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mohaberabi.masterdesignpattern.apply.structural.bridge.UserProfileScreen
import com.mohaberabi.masterdesignpattern.apply.structural.composite.ComposeAbleScreen
import com.mohaberabi.masterdesignpattern.apply.structural.decorator.DecoratorScreen
import com.mohaberabi.masterdesignpattern.ui.theme.MasterDesignPatternTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MasterDesignPatternTheme {
                DecoratorScreen()
            }
        }
    }
}

