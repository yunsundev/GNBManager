package com.ysun.gnbmanager.main.repository.mappers

import com.ysun.gnbmanager.main.repository.entities.ApiRate
import com.ysun.gnbmanager.main.repository.models.Rate
import io.reactivex.Single
import java.math.BigDecimal
import java.math.RoundingMode

class RatesMapper {

    fun toModel(input: List<ApiRate>): Single<List<Rate>> {
        val mappedObjects = ArrayList<Rate>()
        for (item in input) {
            mappedObjects.add(
                Rate.originCurrency(item.from)
                    .destinationCurrency(item.to)
                    .rate(
                        BigDecimal(item.rate.toDouble())
                            .setScale(2, RoundingMode.HALF_EVEN)
                            .toDouble()
                    )
                    .build()
            )
        }
        return Single.just(mappedObjects)
    }
}