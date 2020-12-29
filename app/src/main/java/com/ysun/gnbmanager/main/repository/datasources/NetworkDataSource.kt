package com.ysun.gnbmanager.main.repository.datasources

import com.ysun.gnbmanager.main.repository.entities.ApiRate
import com.ysun.gnbmanager.main.repository.entities.ApiTransaction
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface NetworkDataSource {

    @Headers(
        "Accept: application/json",
        "Content-type:application/json"
    )
    @GET("/rates")
    fun requestRates(): Single<List<ApiRate>>

    @Headers(
        "Accept: application/json",
        "Content-type:application/json"
    )
    @GET("/transactions")
    fun requestTransactions(): Single<List<ApiTransaction>>
}