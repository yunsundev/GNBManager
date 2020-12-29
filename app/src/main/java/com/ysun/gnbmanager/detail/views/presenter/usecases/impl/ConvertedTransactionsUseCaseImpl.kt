package com.ysun.gnbmanager.detail.views.presenter.usecases.impl

import com.ysun.gnbmanager.detail.views.presenter.usecases.ConvertedTransactionsUseCase
import com.ysun.gnbmanager.main.repository.models.Rate
import com.ysun.gnbmanager.main.repository.models.Transaction
import java.math.BigDecimal
import java.math.RoundingMode

class ConvertedTransactionsUseCaseImpl : ConvertedTransactionsUseCase {

    override fun convertTransactionRates(
        rates: List<Rate>,
        transactions: List<Transaction>
    ): List<Transaction> {
        val convertedTransactions = ArrayList<Transaction>()
        for (transaction in transactions) {
            val rate = rateCalculator(transaction.currency, rates)
            convertedTransactions.add(
                Transaction
                    .id(transaction.id)
                    .currency(EUR)
                    .amount(
                        BigDecimal(transaction.amount * rate)
                            .setScale(2, RoundingMode.HALF_EVEN)
                            .toDouble()
                    )
                    .build()
            )
        }
        return convertedTransactions
    }

    private fun rateCalculator(transactionCurrency: String, rates: List<Rate>): Double {
        var convertedRate = 1.0
        var actualizedCurrency = transactionCurrency
        // Meanwhile the transaction currency is not EUR, we'll find the rates needed to get the EUR rate.
        while (actualizedCurrency != EUR) {
            var previousCurrency = actualizedCurrency
            for (rate in rates) {
                // If we find a rate that the destination currency is EUR
                // and the origin currency it's the same as ours, we'll return it's rate
                if (actualizedCurrency == rate.originCurrency && rate.destinationCurrency == EUR) {
                    return rate.rate
                } else {
                    if (actualizedCurrency == rate.originCurrency && rate.destinationCurrency != previousCurrency) {
                        previousCurrency = rate.originCurrency
                        actualizedCurrency = rate.destinationCurrency
                        convertedRate *= rate.rate
                    }
                }
            }
        }
        return convertedRate
    }

    override fun calculateTotalTransactionsInEur(
        transactions: List<Transaction>
    ): Double {
        var total = 0.0
        for (transaction in transactions) total += transaction.amount
        return BigDecimal(total)
            .setScale(2, RoundingMode.HALF_EVEN)
            .toDouble()
    }

    companion object {
        private const val EUR: String = "EUR"
    }

}