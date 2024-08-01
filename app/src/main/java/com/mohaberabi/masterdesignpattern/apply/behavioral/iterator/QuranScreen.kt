package com.mohaberabi.masterdesignpattern.apply.behavioral.iterator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.iterator.base.AppIterator
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.iterator.impl.Quran
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.iterator.impl.QuranIterator
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.iterator.impl.QuranIteratorAggregator
import kotlinx.coroutines.delay


val qurans = buildList<Quran> {
    add(Quran("سورة البقرة"))
    add(Quran("سورة مريم"))
    add(Quran("سورة الفرقان"))
    add(Quran("سورة ال عمران"))
    add(Quran("سورة الملك"))
    add(Quran("سورة يوسف"))
    add(Quran("سورة الأخلاص"))
    add(Quran("سورة الكهف"))
    add(Quran("سورة التكوير"))
    add(Quran("سورة الواقعة"))
    add(Quran("سورة الأنبياء"))
}

@Composable
fun QuranScreen(modifier: Modifier = Modifier) {

    val iterator = rememberQuranIterator(
        qurans = qurans,
    )


    var currentQuran by remember {
        val current = if (iterator.hasNext()) iterator.next().name else ""
        mutableStateOf(current)
    }

    LaunchedEffect(
        key1 = Unit,
    ) {

        while (iterator.hasNext()) {
            delay(2000)
            currentQuran = iterator.next().name
        }
    }



    Scaffold { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {


            Text(
                text = "اقرا بأسم ربك الذي خلق", style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,

                    )
            )
            Text(
                text = currentQuran,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp

                )
            )
        }
    }
}


@Composable
fun rememberQuranIterator(
    qurans: List<Quran>
): AppIterator<Quran> {
    return remember {
        QuranIteratorAggregator(qurans).create()
    }
}