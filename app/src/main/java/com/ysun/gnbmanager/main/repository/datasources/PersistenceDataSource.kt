package com.ysun.gnbmanager.main.repository.datasources

import com.google.gson.reflect.TypeToken
import com.ysun.gnbmanager.base.utils.SharedPreferencesManager
import com.ysun.gnbmanager.main.repository.models.Transaction
import io.reactivex.Observable

class PersistenceDataSource {

    fun findRelatedTransactions(transactionId: String): Observable<List<Transaction>> {
        val type = object : TypeToken<HashMap<String, MutableList<Transaction>>>() {}.type
        val transactions = SharedPreferencesManager.get(
            TRANSACTIONS,
            type
        ) as Map<String, MutableList<Transaction>>
        return Observable.just(transactions[transactionId])
    }

    fun retrieveAllTransactions(): Observable<Map<String, List<Transaction>>> {
        val type = object : TypeToken<HashMap<String, MutableList<Transaction>>>() {}.type
        return Observable.just(
            SharedPreferencesManager.get(
                TRANSACTIONS,
                type
            ) as Map<String, MutableList<Transaction>>
        )
    }


    fun saveTransactions(transactions: Map<String, List<Transaction>>) {
        SharedPreferencesManager.put(transactions, TRANSACTIONS)
    }

    companion object {
        private const val TRANSACTIONS = "GNBManagerTransactions"
    }
}