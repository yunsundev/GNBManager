package com.ysun.gnbmanager.main.repository.models

class Transaction(var id: String, var amount: String, var currency: String) {

    companion object Builder {

        private lateinit var id: String
        private lateinit var amount: String
        private lateinit var currency: String

        fun id(id: String): Builder {
            this.id = id
            return this
        }

        fun amount(amount: String): Builder {
            this.amount = amount
            return this
        }

        fun currency(currency: String): Builder {
            this.currency = currency
            return this
        }


        fun build(): Transaction = Transaction(id, amount, currency)
    }
}