package dev.murmurations.areacalculator

import kotlinx.coroutines.flow.*

class AreaCalculationNative: AreaCalculation {
    val widthNullable = MutableStateFlow<Float?>(null)
    val heightNullable = MutableStateFlow<Float?>(null)

    fun setWidth(value: Double) { widthNullable.value = value.toFloat() }
    fun setHeight(value: Double) { heightNullable.value = value.toFloat() }

    override val width = widthNullable.filterNotNull()
    override val height = heightNullable.filterNotNull()

    override val area = super.area

    suspend fun asyncArea() = area.first()
}
