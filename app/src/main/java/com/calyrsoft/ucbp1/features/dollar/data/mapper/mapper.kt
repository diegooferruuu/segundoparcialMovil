package com.calyrsoft.ucbp1.features.dollar.data.mapper


import com.calyrsoft.ucbp1.features.dollar.data.database.entity.DollarEntity
import com.calyrsoft.ucbp1.features.dollar.domain.model.DollarModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun DollarEntity.toModel() : DollarModel {
    return DollarModel(
        dollarOfficial = dollarOfficial,
        dollarParallel = dollarParallel
    )
}


fun DollarModel.toEntity() : DollarEntity {
    return DollarEntity(
        dollarOfficial = dollarOfficial,
        dollarParallel = dollarParallel,
        USDT = USDT,
        USDC = USDC)
}

