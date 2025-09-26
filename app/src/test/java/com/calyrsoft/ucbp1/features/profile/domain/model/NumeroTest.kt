package com.calyrsoft.ucbp1.features.profile.domain.model

import com.calyrsoft.ucbp1.features.profile.domain.valueobjects.Numero
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.fail
import org.junit.Test

class NumeroTest {

    @Test
    fun `Numero valido`() {
        val numero = Numero("76990995")
        assertEquals("76990995", numero.value)
        assertEquals("76990995", numero.toString())
    }


    @Test
    fun `Numero vacio lanza excepcion`() {
        try {
            Numero("")
            fail("Se esperaba IllegalArgumentException para numero vacío")
        } catch (e: IllegalArgumentException) {
            assertEquals("El número no puede estar vacío", e.message)
        }
    }

    @Test
    fun `Numero con letras lanza excepcion`() {
        try {
            Numero("76A43210")
            fail("Se esperaba IllegalArgumentException para numero con letras")
        } catch (e: IllegalArgumentException) {
            assertEquals("El número solo debe contener dígitos", e.message)
        }
    }

    @Test
    fun `Numero demasiado corto lanza excepcion`() {
        try {
            Numero("1234567")
            fail("Se esperaba IllegalArgumentException para numero demasiado corto")
        } catch (e: IllegalArgumentException) {
            assertEquals("El número debe tener entre 8 y 15 dígitos", e.message)
        }
    }

    @Test
    fun `Numero demasiado largo lanza excepcion`() {
        try {
            Numero("1234567890123456")
            fail("Se esperaba IllegalArgumentException para numero demasiado largo")
        } catch (e: IllegalArgumentException) {
            assertEquals("El número debe tener entre 8 y 15 dígitos", e.message)
        }
    }

    @Test
    fun `Numero con longitud limite pasa`() {
        val numero8 = Numero("12345678")
        val numero15 = Numero("123456789012345")
        assertEquals("12345678", numero8.value)
        assertEquals("123456789012345", numero15.value)
    }
}