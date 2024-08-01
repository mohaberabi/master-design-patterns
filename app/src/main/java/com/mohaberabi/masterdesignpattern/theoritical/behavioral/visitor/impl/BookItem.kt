package com.mohaberabi.masterdesignpattern.theoritical.behavioral.visitor.impl

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.visitor.base.ShoppingItem
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.visitor.base.ShoppingVisitor

data class BookItem(
    val price: Double,
    val weight: Double,
    val name: String,

    ) : ShoppingItem {
    override fun accept(visitor: ShoppingVisitor) {
        visitor.visit(this)
    }
}

data class ElectronicsItem(
    val price: Double,
    val year: Int,
    val name: String,

    ) : ShoppingItem {
    override fun accept(visitor: ShoppingVisitor) {
        visitor.visit(this)
    }
}

data class FoodItem(
    val price: Double,
    val name: String,

    val cookingPrice: Double,
) : ShoppingItem {
    override fun accept(visitor: ShoppingVisitor) {
        visitor.visit(this)
    }
}