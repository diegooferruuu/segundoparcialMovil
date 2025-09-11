package com.calyrsoft.ucbp1.features.profile.data.repository

import com.calyrsoft.ucbp1.features.profile.domain.model.ProfileModel
import com.calyrsoft.ucbp1.features.profile.domain.repository.IProfileRepository

class ProfileRepository : IProfileRepository {
    override fun getUserProfile(): Result<ProfileModel> {
        return Result.success(
            ProfileModel("Fernando Garcia",
                "fernando.garcia@ucb.edu.bo",
                "76990995",
                "Estudiante de Ing. De Sistemas")
        )
    }
}