package com.ysun.gnbmanager.main.repository

import com.ysun.gnbmanager.main.repository.models.Rate
import com.ysun.gnbmanager.main.repository.models.Transaction
import io.reactivex.Observable

interface NetworkRepository {
    fun requestRates(): Observable<List<Rate>>
    fun requestTransactions(): Observable<Map<String, MutableList<Transaction>>>
}