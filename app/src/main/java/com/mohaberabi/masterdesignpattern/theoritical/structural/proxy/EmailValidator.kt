package com.mohaberabi.masterdesignpattern.theoritical.structural.proxy

interface EmailValidator {

    fun isValid(email: String): Boolean
}


class DefaultEmailValidator : EmailValidator {

    override fun isValid(email: String): Boolean {
        return email.contains("@") && email.contains(".")
    }
}


class LazyEmailValidatorProxy : EmailValidator {

    private lateinit var validator: DefaultEmailValidator

    override fun isValid(email: String): Boolean {

        if (!::validator.isInitialized) {
            validator = DefaultEmailValidator()
        }
        return validator.isValid(email)
    }
}