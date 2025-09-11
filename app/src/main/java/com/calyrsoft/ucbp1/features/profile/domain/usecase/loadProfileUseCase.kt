package com.calyrsoft.ucbp1.features.profile.domain.usecase

import com.calyrsoft.ucbp1.features.profile.domain.model.ProfileModel
import com.calyrsoft.ucbp1.features.profile.domain.repository.IProfileRepository
import kotlinx.coroutines.delay

class loadProfileUseCase(
    val repository: IProfileRepository
) {
    suspend fun invoke() : Result<ProfileModel>{
        delay(500)
        return repository.getUserProfile()
    }
}