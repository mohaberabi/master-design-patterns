package com.mohaberabi.masterdesignpattern.theoritical.behavioral.visitor.base

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.visitor.impl.BookItem
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.visitor.impl.ElectronicsItem
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.visitor.impl.FoodItem

interface ShoppingItem {


    fun accept(visitor: ShoppingVisitor)
}


interface ShoppingVisitor {
    fun visit(item: BookItem)

    fun visit(item: ElectronicsItem)
    fun visit(item: FoodItem)

}