package com.example.biodataapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.biodataapp.ui.theme.BioDataAppTheme


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BioDataAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // Greeting("Android")
                    BioDataForm()
                }
            }


        }
    }

}

@Composable
fun BioDataForm() {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var school by remember { mutableStateOf("") }
    var nickname by remember { mutableStateOf("") }
    var emergencyContact by remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Button(
                onClick = {

                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Take Picture")
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "BioData Form", style = MaterialTheme.typography.h5)
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.padding(top = 8.dp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email Address") },
                modifier = Modifier.padding(top = 8.dp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )
            OutlinedTextField(
                value = school,
                onValueChange = { school = it },
                label = { Text("School") },
                modifier = Modifier.padding(top = 8.dp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )
            OutlinedTextField(
                value = nickname,
                onValueChange = { nickname = it },
                label = { Text("Nickname") },
                modifier = Modifier.padding(top = 8.dp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )
            OutlinedTextField(
                value = emergencyContact,
                onValueChange = { emergencyContact = it },
                label = { Text("Emergency Contact") },
                modifier = Modifier.padding(top = 8.dp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
            )


            Button(
                onClick = {
                    val intent = Intent(context, DisplayActivity::class.java).apply {
                        putExtra("name", name)
                        putExtra("email", email)
                        putExtra("school", school)
                        putExtra("nickname", nickname)
                        putExtra("emergencyContact", emergencyContact)
                    }
                    context.startActivity(intent)
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Submit")
            }
        }
    }
}

