package com.calyrsoft.ucbp1.features.profile.domain.valueobjects


@JvmInline
value class Correo (val value: String) {
    init{
        require( value.isNotEmpty()) {
            "Email must not be empty"
        }
        require( value.contains( other = "@")) {
            "Email must contain '@'"
        }
    }
    override fun toString(): String = value
}
