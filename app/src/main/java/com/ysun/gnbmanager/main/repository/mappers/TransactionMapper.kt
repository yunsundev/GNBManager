package com.ysun.gnbmanager.main.repository.mappers

import com.ysun.gnbmanager.main.repository.entities.ApiTransaction
import com.ysun.gnbmanager.main.repository.models.Transaction
import io.reactivex.Single

class TransactionMapper {

    fun toModel(input: List<ApiTransaction>): Single<Map<String, MutableList<Transaction>>> {
        val mappedObjects = HashMap<String, MutableList<Transaction>>()
        for (item in input) {
            if (mappedObjects[item.sku] == null) {
                mappedObjects[item.sku] = mutableListOf(
                    Transaction
                        .id(item.sku)
                        .amount(item.amount.toDouble())
                        .currency(item.currency)
                        .build()
                )
            } else {
                mappedObjects[item.sku]?.add(
                    Transaction
                        .id(item.sku)
                        .amount(item.amount.toDouble())
                        .currency(item.currency)
                        .build()
                )
            }
        }
        return Single.just(mappedObjects)
    }

}