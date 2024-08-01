package com.mohaberabi.masterdesignpattern

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mohaberabi.masterdesignpattern.apply.behavioral.chain_of_responsiblity.HelpScreen
import com.mohaberabi.masterdesignpattern.apply.behavioral.iterator.QuranScreen
import com.mohaberabi.masterdesignpattern.apply.behavioral.memento.BlogScreen
import com.mohaberabi.masterdesignpattern.apply.behavioral.observer.TemperatureScreen
import com.mohaberabi.masterdesignpattern.apply.behavioral.strategy.CartScreen
import com.mohaberabi.masterdesignpattern.ui.theme.MasterDesignPatternTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MasterDesignPatternTheme {
                HelpScreen()
            }
        }
    }
}

