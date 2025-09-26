package com.calyrsoft.ucbp1.features.profile.domain.model

import com.calyrsoft.ucbp1.features.profile.domain.valueobjects.*
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.fail
import org.junit.Test

class ProfileModelTest {

    @Test
    fun `ProfileModel valido`() {
        val profile = ProfileModel(
            nombre = Nombre("Fernando Garcia"),
            correo = Correo("fernando.garcia@ucb.edu.bo"),
            numero = Numero("76990995"),
            descripcion = Descripcion("Estudiante de Ing. de Sistemas")
        )

        assertEquals("Fernando Garcia", profile.nombre.value)
        assertEquals("fernando.garcia@ucb.edu.bo", profile.correo.value)
        assertEquals("76990995", profile.numero.value)
        assertEquals("Estudiante de Ing. de Sistemas", profile.descripcion.value)
    }


    @Test
    fun `ProfileModel con nombre invalido lanza excepcion`() {
        try {
            ProfileModel(
                nombre = Nombre("J"), // demasiado corto
                correo = Correo("fernando.garcia@ucb.edu.bo"),
                numero = Numero("76990995"),
                descripcion = Descripcion("Estudiante de Ing. de Sistemas")
            )
            fail("Se esperaba IllegalArgumentException para nombre inválido")
        } catch (e: IllegalArgumentException) {

        }
    }


    @Test
    fun `ProfileModel con correo invalido lanza excepcion`() {
        try {
            ProfileModel(
                nombre = Nombre("Fernando Garcia"),
                correo = Correo("fernan.do.gmail.com"), // sin @
                numero = Numero("76990995"),
                descripcion = Descripcion("Estudiante de Ing. de Sistemas")
            )
            fail("Se esperaba IllegalArgumentException para correo inválido")
        } catch (e: IllegalArgumentException) {
        }
    }


    @Test
    fun `ProfileModel con numero invalido lanza excepcion`() {
        try {
            ProfileModel(
                nombre = Nombre("Fernando Garcia"),
                correo = Correo("fernando.garcia@ucb.edu.bo"),
                numero = Numero("1234"), // demasiado corto
                descripcion = Descripcion("Estudiante de Ing. de Sistemas")
            )
            fail("Se esperaba IllegalArgumentException para numero inválido")
        } catch (e: IllegalArgumentException) {
        }
    }


    @Test
    fun `ProfileModel con descripcion invalida lanza excepcion`() {
        val textoLargo = "A".repeat(251)
        try {
            ProfileModel(
                nombre = Nombre("Fernando Garcia"),
                correo = Correo("fernando.garcia@ucb.edu.bo"),
                numero = Numero("76990995"),
                descripcion = Descripcion(textoLargo) // >250 caracteres
            )
            fail("Se esperaba IllegalArgumentException para descripcion inválida")
        } catch (e: IllegalArgumentException) {

        }
    }
}
