package com.ysun.gnbmanager.dagger

import com.ysun.gnbmanager.main.repository.NetworkRepository
import com.ysun.gnbmanager.main.repository.datasources.NetworkDataSource
import com.ysun.gnbmanager.main.repository.impl.NetworkRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providesNetworkRepository(networkDataSource: NetworkDataSource): NetworkRepository {
        return NetworkRepositoryImpl(networkDataSource)
    }
}

