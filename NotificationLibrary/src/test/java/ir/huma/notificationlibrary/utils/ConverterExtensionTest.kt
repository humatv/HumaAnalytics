package ir.huma.notificationlibrary.utils

import ir.huma.notificationlibrary.utils.extension.ConverterExtension.getValidPhone
import org.junit.Assert.*

import org.junit.Test

class ConverterExtensionTest {

    @Test
    fun getValidPhone() {
        val validInput1="09151646562"
        val validInput2="+989151646562"
        val invalidInput3="09151z46562"
        val invalidInput4="0915164656"
        val invalidInput5="9151646562"
        val invalidInput6=" "

        assertEquals("+989151646562",validInput2.getValidPhone())
        assertEquals("+989151646562",validInput1.getValidPhone())
        assertEquals(null,invalidInput3.getValidPhone())
        assertEquals(null,invalidInput4.getValidPhone())
        assertEquals(null,invalidInput5.getValidPhone())
        assertEquals(null,invalidInput6.getValidPhone())
    }
}