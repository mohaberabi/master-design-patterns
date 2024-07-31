package com.mohaberabi.masterdesignpattern.theoritical.behavioral.memento


class TextEditor {

    private var data: String = ""
    fun write(data: String) {
        this.data += data
    }

    fun save(): Memento<String> {
        return Memento(data)

    }

    fun restore(memo: Memento<String>) {
        data = memo.data ?: ""
    }

    fun data(): String = data
}
