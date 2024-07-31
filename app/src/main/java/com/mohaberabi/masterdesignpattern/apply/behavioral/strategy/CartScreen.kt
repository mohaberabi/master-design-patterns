package com.mohaberabi.masterdesignpattern.apply.behavioral.strategy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.strategy.ListSorter
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.strategy.base.SortingStrategy
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.strategy.impl.BubbleSortSortingStrategy
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.strategy.impl.MergeSortSortingStrategy
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.strategy.impl.QuickSortSortingStrategy
import kotlin.math.exp
import kotlin.random.Random


enum class SortingType {
    Bubble,
    Quick,
    Merge
}


@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
) {


    var sortingType by remember {
        mutableStateOf(SortingType.Bubble)
    }

    val sortingAlgo by remember {
        mutableStateOf(
            when (sortingType) {
                SortingType.Bubble -> BubbleSortSortingStrategy()
                SortingType.Quick -> QuickSortSortingStrategy()
                SortingType.Merge -> MergeSortSortingStrategy()
            }
        )
    }
    val sorter = rememberListSorter(
        strategy = sortingAlgo,
    )

    var cartItems by remember {
        mutableStateOf(
            buildList {
                repeat(200) {
                    add(
                        Random.nextInt(
                            from = 200,
                            until = 10000
                        )
                    )
                }
            }
        )
    }
    var expanded by remember {

        mutableStateOf(false)
    }
    Scaffold { padding ->
        Column(

            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Your Cart Items",
                )
                TextButton(
                    onClick = {
                        cartItems = cartItems.shuffled()
                    },
                ) {
                    Text(
                        text = "Shuffle",
                    )
                }
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {


                Column(
                    horizontalAlignment = Alignment.Start,
                ) {
                    Row {


                        Text(
                            text = "If You got  confused you can sort them ",
                        )
                        TextButton(
                            onClick = {
                                cartItems = sorter.sort(cartItems)
                            },
                        ) {
                            Text(
                                text = "Sort"
                            )
                        }
                    }
                    Text(
                        text = "Your Sorting Algo is ${sortingType.name}",
                    )
                    TextButton(
                        onClick = {
                            expanded = true
                        },
                    ) {
                        Text(
                            text = "Change "
                        )
                    }
                }


                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    },
                ) {
                    SortingType.entries.forEach {
                        DropdownMenuItem(

                            text = { Text(text = it.name) },
                            onClick = {
                                sortingType = it
                                expanded = false
                            },
                        )
                    }
                }

            }


            LazyColumn {
                items(cartItems.size) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Item ${it + 1}",
                        )
                        Text(
                            text = "Price ${cartItems[it]}",
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun rememberListSorter(
    strategy: SortingStrategy,
): ListSorter {
    return remember {
        ListSorter(strategy)
    }
}