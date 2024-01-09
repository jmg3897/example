package com.gobikebank.example.fixhistory.common.model

data class FixHistories(
    val fixHistories: List<FixHistory>?
) {
    data class FixHistory(
        val serialNumber: String,
        val corpName: String,
        val shopName: String,
        val repairDate: String,
        val supplyCost: String,
        val taxCost: String,
        val paymentCost: String,
        val makerName: String,
        val bikeName: String,
        val bikeId: String,
        val bikeSsn: String,
    )
}
