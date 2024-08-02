package com.mohaberabi.masterdesignpattern.apply.structural.bridge

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mohaberabi.masterdesignpattern.theoritical.structural.bridge.base.ProfileModel
import com.mohaberabi.masterdesignpattern.theoritical.structural.bridge.impl.DefaultProfileRepository
import com.mohaberabi.masterdesignpattern.theoritical.structural.bridge.impl.InMemoryProfileRemoteDataSource


@Composable
fun UserProfileScreen(modifier: Modifier = Modifier) {


    var profile by remember { mutableStateOf<ProfileModel?>(null) }


    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            profile?.let {
                Text("User ID: ${it.id}")
                Text("Name: ${it.name}")
                Text("Email: ${it.email}")
            } ?: Column {

                Text("Looks like you didn't save your data yet ...")
                Button(
                    onClick = {
                        DefaultProfileRepository(InMemoryProfileRemoteDataSource()).apply {
                            profile = getUserData("dummy")
                        }

                    },
                ) {
                    Text(
                        text = "Load from remote",
                    )
                }
            }
        }
    }


}