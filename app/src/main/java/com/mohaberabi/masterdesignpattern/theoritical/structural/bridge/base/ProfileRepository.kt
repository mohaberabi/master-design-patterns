package com.mohaberabi.masterdesignpattern.theoritical.structural.bridge.base


interface ProfileRepository {


    fun getUserData(id: String): ProfileModel?
}