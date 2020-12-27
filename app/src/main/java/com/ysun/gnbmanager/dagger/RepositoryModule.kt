package com.ysun.gnbmanager.dagger

import com.ysun.gnbmanager.main.repository.RatesTransactionsRepository
import com.ysun.gnbmanager.main.repository.datasources.PersistenceDataSource
import com.ysun.gnbmanager.main.repository.datasources.NetworkDataSource
import com.ysun.gnbmanager.main.repository.impl.RatesTransactionsRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providesNetworkRepository(
        networkDataSource: NetworkDataSource,
        persistenceDataSource: PersistenceDataSource
    ): RatesTransactionsRepository {
        return RatesTransactionsRepositoryImpl(networkDataSource, persistenceDataSource)
    }
}

