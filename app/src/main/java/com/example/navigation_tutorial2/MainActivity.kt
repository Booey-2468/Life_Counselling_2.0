package com.example.navigation_tutorial2

import android.annotation.SuppressLint
import android.graphics.Paint.Align
import android.os.Bundle
import android.provider.MediaStore.Video
import android.text.LoginFilter.UsernameFilterGMail
import android.widget.VideoView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier
                .background(color = colorResource(R.color.Thistle))
                .padding(10.dp)
                .fillMaxSize()) {
                Text(text = "Welcome Please In put your Username and password below", textAlign = TextAlign.Center,fontSize = 20.sp)

                TextField(
                    value = Username1,
                    onValueChange = { if (Username1.length <= 20) Username1 = it },
                    singleLine = true,
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .padding(15.dp)
                )
                val textstore1 = Username1
                Row() {
                    Button(onClick = { Username1 = "" },) {
                        Text(text = "Reset Username")

                    }
                    Spacer(modifier = Modifier.width(100.dp))


                    Button(onClick = { navController.navigate(route = "Profile") }, modifier = Modifier.padding(start = 0.dp)) {
                        Text(text = textstore1)
                    }
                }
            }
        }
        composable("Profile") {
            var Username2 by remember { mutableStateOf("")
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
                TextField(value = Username2, onValueChange = {if (Username2.length<=20)Username2 = it}, maxLines = 1, modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(7.dp) )
                val textstore2 =Username2

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