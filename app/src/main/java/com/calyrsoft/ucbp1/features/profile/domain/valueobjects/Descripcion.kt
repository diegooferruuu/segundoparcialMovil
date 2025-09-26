package com.calyrsoft.ucbp1.features.profile.domain.valueobjects

@JvmInline
value class Descripcion(val value: String) {
    init {
        require(value.length <= 250) { "La descripción no debe exceder los 250 caracteres" }
    }
}