package com.example.mylogin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mylogin.ui.theme.MyLoginTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginTheme {
                // A surface container using the 'background' color from the theme
               Scaffold(
                   topBar ={ TopAppBar(backgroundColor = Color.Blue,
                   title = { Text(text = "Login")}, modifier = Modifier.padding(10.dp)) }
               ) {
                   Surface(
                       modifier = Modifier.fillMaxSize(),
                       color = MaterialTheme.colors.background
                   ) {
                       Login()
                   }
               }
            }
        }
    }
}

@Composable
fun Login() {
    var context= LocalContext.current
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var LoginError by remember { mutableStateOf("") }
    LoginError=""
 Column(modifier = Modifier.fillMaxSize(),
 horizontalAlignment = Alignment.CenterHorizontally) {
    OutlinedTextField(value =username , onValueChange ={username=it},
        singleLine = true,
        placeholder = { Text(text = "Enter username")}
        )
    Spacer(modifier = Modifier.height(8.dp))
     OutlinedTextField(value =password ,
         onValueChange ={password=it},
         singleLine = true,
         placeholder = { Text(text = "Enter password")}
        )
     Spacer(modifier = Modifier.height(8.dp))
     OutlinedButton(onClick = {
         if(username.isNotEmpty() && password.isNotEmpty())
         {
             if(username.equals("Seme") && password.equals("1234"))
             {
                LoginError="Successfully logged in"
                
             }
             else
             {
                 LoginError="Wrong username or password"
             }
         }
         else
         {
             LoginError=" Enter all the information"
         }
         Toast.makeText(context,LoginError,Toast.LENGTH_SHORT).show()

     }) {
         Text(text = "Login")

     }

 }
    //Text(text = LoginError, color = Color.Red)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyLoginTheme {
        Login()
    }
}