package dev.murmurations.areacalculator.android

import android.os.Bundle
import android.util.Xml
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.lifecycle.viewmodel.compose.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("|" + Xml.FEATURE_RELAXED + "|")
        setContent {
            MaterialTheme {
                ContentView(viewModel())
            }
        }
    }
}

