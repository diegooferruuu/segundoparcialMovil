package com.calyrsoft.ucbp1.features.profile.domain.valueobjects

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class NombreTest {

    @Test
    fun `Nombre valido`() {
        val nombre = Nombre("Juan Perez")
        assertEquals("Juan Perez", nombre.value)
    }

    @Test
    fun `Nombre demasiado corto lanza excepcion`() {
        try {
            Nombre("J")
            fail("Se esperaba IllegalArgumentException para nombre demasiado corto")
        } catch (e: IllegalArgumentException) {
            // Confirmamos que el mensaje es correcto
            assertEquals("El nombre debe tener al menos 2 caracteres", e.message)
        }
    }
}