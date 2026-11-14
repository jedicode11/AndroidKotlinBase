package com.example.unitconvert

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import java.util.Locale

class LengthConversionTest {
    @Test
    fun convertsFractionalInches() {
        assertEquals(3.81, inchesToCentimeters("1.5", Locale.US)!!, 0.000001)
    }

    @Test
    fun readsLocalizedDecimalSeparator() {
        assertEquals(3.81, inchesToCentimeters("1,5", Locale.GERMANY)!!, 0.000001)
    }

    @Test
    fun rejectsIncompleteOrMalformedInput() {
        for (input in listOf("", " ", ".", "1.2.3", "1inch")) {
            assertNull(input, inchesToCentimeters(input, Locale.US))
        }
    }

    @Test
    fun rejectsNonFiniteConversions() {
        for (input in listOf("NaN", "1E308")) {
            assertNull(input, inchesToCentimeters(input, Locale.US))
        }
    }
}
