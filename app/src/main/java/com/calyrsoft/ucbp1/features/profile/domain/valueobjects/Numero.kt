package com.calyrsoft.ucbp1.features.profile.domain.valueobjects

@JvmInline
value class Numero(val value: String) {
    init {
        require(value.isNotBlank()) { "El número no puede estar vacío" }
        require(value.all { it.isDigit() }) { "El número solo debe contener dígitos" }
        require(value.length in 8..15) { "El número debe tener entre 8 y 15 dígitos" }
    }
    override fun toString(): String = value
}