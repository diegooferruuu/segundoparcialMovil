package com.calyrsoft.ucbp1.features.profile.domain.valueobjects

@JvmInline
value class Nombre(val value: String) {
    init {
        require(value.isNotBlank()) {
            "El nombre no puede estar vacío" }
        require(value.length >= 2) {
            "El nombre debe tener al menos 2 caracteres" }
    }

    override fun toString(): String = value
}