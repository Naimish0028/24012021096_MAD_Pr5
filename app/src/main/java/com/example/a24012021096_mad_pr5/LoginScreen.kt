package com.example.a24012021096_mad_pr5

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(context: Context, navController: NavController)
{

    var email by remember { mutableStateOf("") }
    var passwrod by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(R.drawable.guni_pink_logo),
            contentDescription = "Logo" ,
            modifier = Modifier
                .height(130.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )


        Spacer(modifier = Modifier.height(20.dp))
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp) ,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)) {

                FormFeild("Email",email,{email = it},false,false)
                FormFeild("Password",passwrod,{passwrod=it},true)

                Text(
                    text = "Forgot Passsword ? " ,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(bottom = 50.dp)
                        .align(Alignment.End)
                )

                Button(
                    onClick =  {
                        Log.i("Login Activity", "Login Button Presed")
                    },
                    modifier = Modifier.fillMaxWidth()
                        .padding(16.dp),



                    )
                {
                    Text("Login", fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(25.dp))







            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally) ,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text("Dont have An account ? ", fontSize = 16.sp)
            Spacer(modifier = Modifier.width(50.dp))


            TextButton(onClick = {navController.navigate("register"){
                popUpTo("login"){
                    inclusive = true
                }
            }}) {
                Text("SIGN UP", fontSize = 16.sp, color = Color.Red)
            }
        }
    }

}

@Composable
fun LoginActivityUI(context: Context, navController: NavHostController) {
    LoginScreen(context = context, navController = navController)
}

fun showMsg(context: Context)
{
    Toast.makeText(context, "This is show msg", Toast.LENGTH_SHORT).show()
}
