package com.calyrsoft.ucbp1.features.dollar.domain.model


data class DollarModel(
    var dollarOfficial: String? = null,
    var dollarParallel: String? = null,
    var USDT: String? = null,
    var USDC: String? = null,
    var timestamp: Long? = 0
)