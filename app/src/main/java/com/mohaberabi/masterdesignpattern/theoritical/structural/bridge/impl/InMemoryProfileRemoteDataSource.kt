package com.mohaberabi.masterdesignpattern.theoritical.structural.bridge.impl

import com.mohaberabi.masterdesignpattern.theoritical.structural.bridge.base.ProfileDataSource
import com.mohaberabi.masterdesignpattern.theoritical.structural.bridge.base.ProfileModel

class InMemoryProfileRemoteDataSource : ProfileDataSource {


    override fun getProfile(id: String): ProfileModel? {

        return ProfileModel(
            "1",
            "Loser ",
            "loser@loserdomain.com"
        )
    }
}