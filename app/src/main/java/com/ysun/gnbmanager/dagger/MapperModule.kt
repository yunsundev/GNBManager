package com.ysun.gnbmanager.dagger

import com.ysun.gnbmanager.main.repository.mappers.RatesMapper
import com.ysun.gnbmanager.main.repository.mappers.TransactionMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun providesTransactionsMapper(): TransactionMapper {
        return TransactionMapper()
    }

    @Provides
    fun providesRatesMapper(): RatesMapper {
        return RatesMapper()
    }
}