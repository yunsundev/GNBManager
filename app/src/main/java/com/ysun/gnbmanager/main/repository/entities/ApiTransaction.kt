package com.ysun.gnbmanager.main.repository.entities

import com.google.gson.annotations.SerializedName

data class ApiTransaction(
    @SerializedName("sku") val sku: String,
    @SerializedName("amount") val amount: String,
    @SerializedName("currency") val currency: String
)