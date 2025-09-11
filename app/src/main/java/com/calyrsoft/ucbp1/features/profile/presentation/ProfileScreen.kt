package com.calyrsoft.ucbp1.features.profile.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.calyrsoft.ucbp1.features.profile.domain.model.ProfileModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileModel(
    modifier: Modifier,
    vm: ProfileViewModel = koinViewModel()
    ){
    val state by vm.state.collectAsState()

    Column {

    }

}