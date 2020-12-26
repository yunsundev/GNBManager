package com.ysun.gnbmanager.main.repository.datasources

import com.ysun.gnbmanager.main.repository.entities.ApiRate
import com.ysun.gnbmanager.main.repository.entities.ApiTransaction
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET

interface NetworkDataSource {

    @GET("/rates.json")
    fun requestRates(): Single<List<ApiRate>>

    @GET("/transactions.json")
    fun requestTransactions(): Single<List<ApiTransaction>>
}