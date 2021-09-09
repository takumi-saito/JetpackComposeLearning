package com.example.lesson_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lesson_2.ui.theme.JetpackComposeLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val message = Message(
                "Android",
                "Jetpack Compose"
            )
            MessageCard(message)
        }
    }
}

data class Message(
    val author: String,
    val body: String
    )

@Composable
fun MessageCard(message: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        
        Spacer(modifier = Modifier.width(8.dp))
        
        Column {
            Text(message.author)
            Spacer(modifier = Modifier.height(4.dp))
            Text(message.body)
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    val message = Message(
        "Colleague",
        "Hey, take a look at Jetpack Compose, it's great!"
    )
    Text(message.author)
    Text(message.body)
}