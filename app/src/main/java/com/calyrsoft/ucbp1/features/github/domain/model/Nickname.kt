package com.calyrsoft.ucbp1.features.github.domain.model

@JvmInline
value class Nickname(val value: String) {

    init{
        require(value.isNotEmpty()){
            "Nickname must not be empty"
        }
        require(value.length <= 15){
            "Nickname must be "
        }
        require(value.length > 3){
            "Nickname must be "
        }
    }
}