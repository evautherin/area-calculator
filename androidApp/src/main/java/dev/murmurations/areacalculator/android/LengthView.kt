package dev.murmurations.areacalculator.android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LengthView(
    label: String,
    sliderValue: Float,
    onValueChange: (Float) -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "$label: $sliderValue")
        Slider(value = sliderValue, valueRange = 1f..10f, onValueChange = onValueChange)
    }
}

@Preview(showBackground = true)
@Composable
fun LengthViewPreview() {
    var sliderValue by remember { mutableStateOf(3.0f) }

    LengthView(label = "Value", sliderValue = sliderValue, onValueChange = { sliderValue = it })
}
