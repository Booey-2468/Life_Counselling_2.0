package com.example.navigation_tutorial2

import android.os.Bundle
import android.text.LoginFilter.UsernameFilterGMail
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation_tutorial2.ui.theme.Navigation_Tutorial2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation_Tutorial2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    navigation()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun navigation (navController:NavHostController= rememberNavController()) {
    val navHost = NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            var Username1 by remember {
                mutableStateOf("")
            }
            Column() {
                Text(text = "WELCOME!!!!!!!!!")
                val text_store2 =""
                TextField(value = Username1, onValueChange ={Username1 = it}, maxLines = 1)
                Button(onClick = { navController.navigate(route = "Profile") }) {
                    Text(text = "Continue")
                }
            }
        }
        composable("Profile") {
            var Username2 by remember {
                mutableStateOf("")
            }
                Card(
                    modifier = Modifier.padding(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    onClick = { navController.navigate(route = "home") }) {
                    Image(
                        painter = painterResource(id = R.drawable.cute_kitten_2),
                        contentDescription = null
                    )
                    Text(text = "This is a person which is a person")
                }

                Card(
                    modifier = Modifier.padding(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    val text_store1 =""
                    TextField(value = Username2, onValueChange = {Username2 = it}, maxLines = 1)
                    Image(
                        painter = painterResource(id = R.drawable.unnamed),
                        contentDescription = null
                    )
                    Button(onClick = { navController.navigate(route = "home") }) {
                        Text(text = "Done")
                    }
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Navigation_Tutorial2Theme {
    }
}