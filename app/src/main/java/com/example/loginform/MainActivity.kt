package com.example.loginform

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.Visibility
import com.example.loginform.ui.theme.LoginFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
                // A surface container using the 'background' color from the theme
                LoginForm()
            }
        }
    }
}

@Composable
fun LoginForm() {
    var usernameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }


    Column (
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            ) {
                 Text(
                    text = "Login",
                    color = MaterialTheme.colors.primary,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxWidth()

                 )

                OutlinedTextField(
                    value = usernameInput,
                    onValueChange ={usernameInput=it},
                    label = {Text(text = stringResource(R.string.username))},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email ),
                    singleLine = true,
                    trailingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = passwordInput,
                    onValueChange ={passwordInput = it},
                    label = {Text(text = stringResource(R.string.password))},
                    singleLine = true,
                    visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password ),
                    trailingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock Icon") },
                    modifier = Modifier.fillMaxWidth(),

                    

                )
                Button(onClick = { /*TODO*/ },) {
                    Text(
                        text = "Submit",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )

                }




            }
}
