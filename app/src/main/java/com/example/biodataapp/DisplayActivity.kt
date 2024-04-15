package com.example.biodataapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class DisplayActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra("name") ?: ""
        val email = intent.getStringExtra("email") ?: ""
        val school = intent.getStringExtra("school") ?: ""
        val nickname = intent.getStringExtra("nickname") ?: ""
        val emergencyContact = intent.getStringExtra("emergencyContact") ?: ""

        setContent {
            DisplayDataScreen(name, email, school, nickname, emergencyContact)
        }
    }
}

@Composable
private fun DisplayDataScreen(
    name: String,
    email: String,
    school: String,
    nickname: String,
    emergencyContact: String
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Name: $name")
        Text(text = "Email: $email", modifier = Modifier.padding(top = 8.dp))
        Text(text = "School: $school", modifier = Modifier.padding(top = 8.dp))
        Text(text = "Nickname: $nickname", modifier = Modifier.padding(top = 8.dp))
        Text(text = "Emergency Contact: $emergencyContact", modifier = Modifier.padding(top = 8.dp))
    }

}

