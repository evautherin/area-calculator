package dev.murmurations.areacalculator.android

import androidx.lifecycle.ViewModel
import dev.murmurations.areacalculator.AreaCalculation
import kotlinx.coroutines.flow.*


class AreaViewModel: ViewModel(), AreaCalculation {
    val initialWidth = 2.0f
    val initialHeight = 3.0f

    override val width = MutableStateFlow(initialWidth)
    override val height = MutableStateFlow(initialHeight)

    val setWidth: (Float) -> Unit = { value -> width.value = value }
    val setHeight: (Float) -> Unit = { value -> height.value = value }
}