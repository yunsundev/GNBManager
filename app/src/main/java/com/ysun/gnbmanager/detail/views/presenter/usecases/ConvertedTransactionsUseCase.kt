package com.ysun.gnbmanager.detail.views.presenter.usecases

import com.ysun.gnbmanager.main.repository.models.Rate
import com.ysun.gnbmanager.main.repository.models.Transaction

interface ConvertedTransactionsUseCase {
    fun convertTransactionRates(
        rates: List<Rate>,
        transactions: List<Transaction>
    ): List<Transaction>

    fun calculateTotalTransactionsInEur(
        transactions: List<Transaction>
    ): Double
}