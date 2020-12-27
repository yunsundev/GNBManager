package com.ysun.gnbmanager.main.repository.models

class TransactionList(var transactionId: String, var transactions: List<Transaction>) {

    companion object Builder {

        private lateinit var transactionId: String
        private lateinit var transactions: List<Transaction>

        fun transactionId(id: String): Builder {
            this.transactionId = transactionId
            return this
        }

        fun transactions(transactions: List<Transaction>): Builder {
            this.transactions = transactions
            return this
        }


        fun build(): TransactionList = TransactionList(transactionId, transactions)
    }
}