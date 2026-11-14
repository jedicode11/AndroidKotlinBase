package com.example.unitconvert

import java.text.NumberFormat
import java.text.ParsePosition
import java.util.Locale

private const val CENTIMETERS_PER_INCH = 2.54

internal fun inchesToCentimeters(input: String, locale: Locale): Double? {
    val text = input.trim()
    val format = NumberFormat.getNumberInstance(locale).apply { isGroupingUsed = false }
    val position = ParsePosition(0)
    val inches = format.parse(text, position) ?: return null
    if (position.index != text.length) return null

    return (inches.toDouble() * CENTIMETERS_PER_INCH).takeIf { it.isFinite() }
}
