package com.ysun.gnbmanager.main.presenter.usecases.impl

import com.ysun.gnbmanager.main.presenter.usecases.RequestTransactionUseCase
import com.ysun.gnbmanager.main.repository.RatesTransactionsRepository
import com.ysun.gnbmanager.main.repository.models.Transaction
import io.reactivex.Observable

class RequestTransactionUseCaseImpl(val repository: RatesTransactionsRepository) : RequestTransactionUseCase {

    override fun requestTransactionData(): Observable<Map<String, MutableList<Transaction>>> {
        return repository.requestTransactions()
    }

}