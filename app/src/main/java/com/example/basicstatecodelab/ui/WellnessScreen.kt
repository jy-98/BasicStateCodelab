package com.example.basicstatecodelab.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.basicstatecodelab.WaterCounter

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        StatefulCounter()
        val list = remember { getWellnessTask().toMutableStateList()  }
        WellnessTasksList(list = list, onCloseTask = { task -> list.remove(task) })

    }

}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }

    WaterCounter(count, { count++ }, modifier = modifier)
}


private fun getWellnessTask() = List(1) { i -> WellnessTask(i, "Task # $i") }
