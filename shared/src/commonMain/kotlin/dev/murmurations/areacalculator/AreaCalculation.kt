package dev.murmurations.areacalculator

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine


interface AreaCalculation {
    val width: Flow<Float>
    val height: Flow<Float>

    val calculation: (Float, Float) -> Float
        get() = { width, height -> width*height }

    val area: Flow<Float>
        get() = combine(width, height, transform = calculation)
}
