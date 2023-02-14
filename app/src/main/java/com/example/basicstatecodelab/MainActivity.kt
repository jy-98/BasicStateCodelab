package com.example.basicstatecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.ui.WellnessScreen
import com.example.basicstatecodelab.ui.WellnessTaskItem
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicStateCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WellnessScreen()
                }
            }
        }
    }
}

@Composable
fun WaterCounter(count: Int, onIncrement: ()-> Unit, modifier: Modifier = Modifier) {

    Column(modifier = modifier.padding(16.dp)) {

        if (count > 0){
            var showTask by remember { mutableStateOf(true) }
            if (showTask){
                WellnessTaskItem("Have you taken your 15 minute walk today?") { showTask = false }
            }
            Text(text = "You've had $count glasses.",)
        }
        Row( modifier.padding(top = 8.dp)) {
            Button(onClick =  onIncrement , enabled = count < 10) {
                Text(text = "ADD one")
            }
//            Button(onClick = { count = 0 }, modifier.padding(start = 8.dp)) {
//                Text(text = "Clear water count")
//            }
        }
//        WellnessTasksList()

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicStateCodelabTheme {
        WellnessScreen()
    }
}