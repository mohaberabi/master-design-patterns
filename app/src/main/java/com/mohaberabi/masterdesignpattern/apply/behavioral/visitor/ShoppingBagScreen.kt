package com.mohaberabi.masterdesignpattern.apply.behavioral.visitor

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.visitor.impl.BookItem
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.visitor.impl.CartVisitor
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.visitor.impl.ElectronicsItem
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.visitor.impl.FoodItem


private val items = listOf(
    BookItem(name = "Kotlin ", price = 200.0, weight = 0.5),
    FoodItem(name = "Kotlin ", price = 200.0, cookingPrice = 0.5),
    ElectronicsItem(name = "Kotlin ", price = 200.0, year = 2024),
)

@Composable
fun ShoppingBagScreen(
    modifier: Modifier = Modifier,
) {

    val visitor = rememberCartVisitor()



    LaunchedEffect(key1 = Unit) {
        for (item in items) {
            item.accept(visitor)
        }
    }




    Text(text = "Cart Total :${visitor.cartTotal}")


}


@Composable
fun rememberCartVisitor(): CartVisitor {
    return remember {
        CartVisitor()
    }
}