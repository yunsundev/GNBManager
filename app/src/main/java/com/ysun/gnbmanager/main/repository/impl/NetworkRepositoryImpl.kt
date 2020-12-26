package com.ysun.gnbmanager.main.repository.impl

import com.ysun.gnbmanager.main.repository.NetworkRepository
import com.ysun.gnbmanager.main.repository.datasources.NetworkDataSource
import com.ysun.gnbmanager.main.repository.entities.ApiRate
import com.ysun.gnbmanager.main.repository.entities.ApiTransaction
import com.ysun.gnbmanager.main.repository.mappers.RatesMapper
import com.ysun.gnbmanager.main.repository.mappers.TransactionMapper
import com.ysun.gnbmanager.main.repository.models.Rate
import com.ysun.gnbmanager.main.repository.models.Transaction
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NetworkRepositoryImpl(
    private val networkDataSource: NetworkDataSource
) : NetworkRepository {

    override fun requestRates(): Observable<List<Rate>> {
        return networkDataSource.requestRates()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { response: List<ApiRate> -> RatesMapper().toModel(response) }
            .toObservable()
    }

    override fun requestTransactions(): Observable<Map<String, MutableList<Transaction>>> {
        return networkDataSource.requestTransactions()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { response: List<ApiTransaction> -> TransactionMapper().toModel(response) }
            .toObservable()
    }

}