package com.mohaberabi.masterdesignpattern.theoritical.behavioral.memento

class TextEditorHistory {


    private val mementos = mutableListOf<Memento<String>>()


    fun save(memento: Memento<String>) {
        mementos.add(memento)
    }

    fun undo(): Memento<String>? {
        return if (mementos.isNotEmpty()) {
            mementos.removeAt(mementos.lastIndex)
        } else {
            null
        }

    }
}