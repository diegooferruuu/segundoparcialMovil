package com.calyrsoft.ucbp1.features.profile.domain.model

import com.calyrsoft.ucbp1.features.profile.domain.valueobjects.*


data class ProfileModel(val nombre: Nombre, val correo: Correo, val numero: Numero, val descripcion: Descripcion)