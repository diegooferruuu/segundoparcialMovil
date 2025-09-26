package com.calyrsoft.ucbp1.features.profile.domain.usecase

import com.calyrsoft.ucbp1.features.profile.domain.model.ProfileModel
import com.calyrsoft.ucbp1.features.profile.domain.repository.IProfileRepository
import com.calyrsoft.ucbp1.features.profile.domain.valueobjects.*
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test


class LoadProfileUseCaseTest {

    private val repository: IProfileRepository = mockk()
    private val useCase = loadProfileUseCase(repository)

    @Test
    fun `invoke devuelve perfil correctamente`() = runTest {
        // Arrange: crear un ProfileModel válido
        val profile = ProfileModel(
            nombre = Nombre("Fernando Garcia"),
            correo = Correo("fernando.garcia@ucb.edu.bo"),
            numero = Numero("76990995"),
            descripcion = Descripcion("Estudiante de Ing. de Sistemas")
        )

        coEvery { repository.getUserProfile() } returns Result.success(profile)
        val result = useCase.invoke()

        assertEquals(true, result.isSuccess)
        assertEquals(profile, result.getOrNull())

        coVerify(exactly = 1) { repository.getUserProfile() }
    }

    @Test
    fun `invoke devuelve error cuando repositorio falla`() = runTest {
        val error = Exception("Error de red")
        coEvery { repository.getUserProfile() } returns Result.failure(error)

        val result = useCase.invoke()

        assertEquals(true, result.isFailure)
        assertEquals(error, result.exceptionOrNull())

        coVerify(exactly = 1) { repository.getUserProfile() }
    }
}