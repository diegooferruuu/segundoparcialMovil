package com.calyrsoft.ucbp1.features.login.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.calyrsoft.ucbp1.features.github.presentation.GithubViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(modifier: Modifier,
              vm: LoginViewModel = koinViewModel()
){
    var mailSignIn by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val state by vm.state.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text("Sign In")
        TextField(mailSignIn, onValueChange = {mailSignIn = it})
        TextField(password, onValueChange = {password = it})
        Button(modifier = Modifier.fillMaxWidth(), onClick = {vm.fetchLogin(mailSignIn, password)}) {
            Text("Sign In")
        }
        when( val st = state) {
            is LoginViewModel.LoginStateUI.Error -> {
                Text(st.errorMessage )
            }
            LoginViewModel.LoginStateUI.Init -> {
                Text("Init" )
            }
            LoginViewModel.LoginStateUI.Loading -> {
                Text("Loading" )
            }
            is LoginViewModel.LoginStateUI.Success -> {
                Text("Welcome")
            }
        }
    }

}

