package com.ysun.gnbmanager.main.repository.entities

import com.google.gson.annotations.SerializedName

data class ApiRate(
    @SerializedName("from") val from: String,
    @SerializedName("to") val to: String,
    @SerializedName("rate") val rate: String
)