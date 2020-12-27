package com.ysun.gnbmanager.main.presenter.usecases

import com.ysun.gnbmanager.main.repository.models.Transaction
import io.reactivex.Observable

interface RelatedTransactionsUseCase {
    fun saveTransactions(transactions: Map<String, MutableList<Transaction>>)
    fun findTransactionList(transactionId: String): Observable<List<Transaction>>
}