package dev.murmurations.areacalculator.android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ContentView(
    viewModel: AreaViewModel
) {
    val width by viewModel.width.collectAsState(viewModel.initialWidth)
    val height by viewModel.height.collectAsState(viewModel.initialHeight)
    val area by viewModel.area.collectAsState(null)

    Column {
        LengthView("Width", width, viewModel.setWidth)
        LengthView("Height", height, viewModel.setHeight)
        area?.let {
            Text(text = "Area: $it", modifier = Modifier.padding(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ContentView(viewModel = viewModel())
}
