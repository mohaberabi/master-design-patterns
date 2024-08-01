package com.mohaberabi.masterdesignpattern.theoritical.behavioral.visitor.impl

import com.mohaberabi.masterdesignpattern.theoritical.behavioral.visitor.base.ShoppingVisitor


class CartVisitor : ShoppingVisitor {
    var cartTotal = 0.0
        private set

    override fun visit(item: BookItem) {

        val total = item.price * item.weight
        cartTotal += total
    }

    override fun visit(item: ElectronicsItem) {
        val total = item.price * item.year
        cartTotal += total
    }

    override fun visit(item: FoodItem) {
        val total = item.price * item.cookingPrice + 200
        cartTotal += total
    }
}