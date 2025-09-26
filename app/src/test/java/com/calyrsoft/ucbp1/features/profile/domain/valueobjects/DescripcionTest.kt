package com.calyrsoft.ucbp1.features.profile.domain.valueobjects

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.fail
import org.junit.Test

class DescripcionTest {
    @Test
    fun `Descripcion valida`() {
        val descripcion = Descripcion("Estudiante de Ing. de Sistemas")
        assertEquals("Estudiante de Ing. de Sistemas", descripcion.value)
    }

    @Test
    fun `Descripcion con longitud limite pasa`() {
        val texto250 = "A".repeat(250)
        val descripcion = Descripcion(texto250)
        assertEquals(texto250, descripcion.value)
    }

    @Test
    fun `Descripcion demasiado larga lanza excepcion`() {
        val textoLargo = "A".repeat(251)
        try {
            Descripcion(textoLargo)
            fail("Se esperaba IllegalArgumentException para descripción > 250 caracteres")
        } catch (e: IllegalArgumentException) {
            assertEquals("La descripción no debe exceder los 250 caracteres", e.message)
        }
    }
}