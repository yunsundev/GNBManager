package com.ysun.gnbmanager.main.repository.models

import java.io.Serializable


data class Transaction(var id: String, var amount: Double, var currency: String) : Serializable{

    companion object Builder {

        private lateinit var id: String
        private var amount: Double = 0.0
        private lateinit var currency: String

        fun id(id: String): Builder {
            this.id = id
            return this
        }

        fun amount(amount: Double): Builder {
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