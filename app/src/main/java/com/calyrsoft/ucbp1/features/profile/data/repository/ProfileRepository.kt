package com.calyrsoft.ucbp1.features.profile.data.repository

import com.calyrsoft.ucbp1.features.profile.domain.model.ProfileModel
import com.calyrsoft.ucbp1.features.profile.domain.repository.IProfileRepository
import com.calyrsoft.ucbp1.features.profile.domain.valueobjects.*

class ProfileRepository : IProfileRepository {
    override fun getUserProfile(): Result<ProfileModel> {
        return Result.success(
            ProfileModel(
                nombre = Nombre("Diego Ferruuuu"),
                correo = Correo("diego.ferrufino@ucb.edu.bo"),
                numero = Numero("79955355"),
                descripcion = Descripcion("Ing. de Sistemas")
            )
        )
    }
}