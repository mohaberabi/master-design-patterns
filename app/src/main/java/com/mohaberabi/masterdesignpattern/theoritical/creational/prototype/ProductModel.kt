package com.mohaberabi.masterdesignpattern.theoritical.creational.prototype

data class ProductModel(
    val id: String,
    val name: String,
    val price: Double,
) : Prototype<ProductModel> {
    override fun clone(): ProductModel {
        return copy()
    }
}
