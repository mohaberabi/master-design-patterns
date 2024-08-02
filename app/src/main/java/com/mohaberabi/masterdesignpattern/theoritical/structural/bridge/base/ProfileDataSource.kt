package com.mohaberabi.masterdesignpattern.theoritical.structural.bridge.base

interface ProfileDataSource {


    fun getProfile(id: String): ProfileModel?

}