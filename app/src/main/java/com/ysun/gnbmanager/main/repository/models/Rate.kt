package com.ysun.gnbmanager.main.repository.models

class Rate(
    private val originCurrency: String,
    private val destinationCurrency: String,
    private val rate: Double
) {

    companion object Builder {

        private lateinit var originCurrency: String
        private lateinit var destinationCurrency: String
        private var rate: Double = 0.0

        fun originCurrency(originCurrency: String): Builder {
            this.originCurrency = originCurrency
            return this
        }

        fun destinationCurrency(destinationCurrency: String): Builder {
            this.destinationCurrency = destinationCurrency
            return this
        }

        fun rate(rate: Double): Builder {
            this.rate = rate
            return this
        }

        fun build(): Rate {
            return Rate(originCurrency, destinationCurrency, rate)
        }
    }
}