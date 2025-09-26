package com.calyrsoft.ucbp1.features.profile.domain.valueobjects

import junit.framework.TestCase.assertEquals
import org.junit.Assert.fail
import org.junit.Test


class CorreoTest {
    @Test
    fun `Correo valido`() {
        val correo = Correo("juan.perez@ucb.edu.bo")
        assertEquals("juan.perez@ucb.edu.bo", correo.value)
        assertEquals("juan.perez@ucb.edu.bo", correo.toString())
    }

    @Test
    fun `Correo vacio lanza excepcion`() {
        try {
            Correo("")
            fail("Se esperaba IllegalArgumentException para correo vacío")
        } catch (e: IllegalArgumentException) {
            assertEquals("Email must not be empty", e.message)
        }
    }

    @Test
    fun `Correo sin arroba lanza excepcion`() {
        try {
            Correo("juan.perez.ucb.edu.bo")
            fail("Se esperaba IllegalArgumentException para correo sin '@'")
        } catch (e: IllegalArgumentException) {
            assertEquals("Email must contain '@'", e.message)
        }
    }
}