package com.mohaberabi.masterdesignpattern.theoritical.structural.bridge.impl

import com.mohaberabi.masterdesignpattern.theoritical.structural.bridge.base.ProfileDataSource
import com.mohaberabi.masterdesignpattern.theoritical.structural.bridge.base.ProfileModel
import com.mohaberabi.masterdesignpattern.theoritical.structural.bridge.base.ProfileRepository

class DefaultProfileRepository(
    private val dataSource: ProfileDataSource
) : ProfileRepository {
    override fun getUserData(id: String): ProfileModel? = dataSource.getProfile(id)
}