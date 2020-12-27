package com.ysun.gnbmanager.main.presenter.usecases.impl

import com.ysun.gnbmanager.main.presenter.usecases.RelatedTransactionsUseCase
import com.ysun.gnbmanager.main.repository.RatesTransactionsRepository
import com.ysun.gnbmanager.main.repository.models.Transaction
import io.reactivex.Observable

class RelatedTransactionsUseCaseImpl(private val repository: RatesTransactionsRepository) :
    RelatedTransactionsUseCase {
    override fun saveTransactions(transactions: Map<String, MutableList<Transaction>>) {
        repository.saveTransactions(transactions)
    }

    override fun findTransactionList(transactionId: String): Observable<List<Transaction>> {
        return repository.findRelatedTransactions(transactionId)
    }
}