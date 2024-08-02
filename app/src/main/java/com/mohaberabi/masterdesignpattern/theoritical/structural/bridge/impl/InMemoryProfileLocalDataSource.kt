package com.mohaberabi.masterdesignpattern.theoritical.structural.bridge.impl

import com.mohaberabi.masterdesignpattern.theoritical.structural.bridge.base.ProfileDataSource
import com.mohaberabi.masterdesignpattern.theoritical.structural.bridge.base.ProfileModel

class InMemoryProfileLocalDataSource : ProfileDataSource {
    override fun getProfile(id: String): ProfileModel? = null
}