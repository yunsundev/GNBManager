package com.ysun.gnbmanager.main.repository.mappers

import com.ysun.gnbmanager.main.repository.entities.ApiTransaction
import com.ysun.gnbmanager.main.repository.models.Transaction
import io.reactivex.Single
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

class TransactionMapper {

    fun toModel(input: List<ApiTransaction>): Single<Map<String, MutableList<Transaction>>> {
        val mappedObjects = HashMap<String, MutableList<Transaction>>()
        for (item in input) {
            if (mappedObjects[item.sku] == null) {
                mappedObjects[item.sku] = mutableListOf(
                    Transaction
                        .id(item.sku)
                        .amount(
                            BigDecimal(item.amount.toDouble())
                            .setScale(2, RoundingMode.HALF_EVEN)
                            .toDouble())
                        .currency(item.currency)
                        .build()
                )
            } else {
                mappedObjects[item.sku]?.add(
                    Transaction
                        .id(item.sku)
                        .amount(BigDecimal(item.amount.toDouble())
                            .setScale(2, RoundingMode.HALF_EVEN)
                            .toDouble())
                        .currency(item.currency)
                        .build()
                )
            }
        }
        return Single.just(mappedObjects)
    }

}