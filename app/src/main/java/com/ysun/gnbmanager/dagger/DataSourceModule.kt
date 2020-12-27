package com.ysun.gnbmanager.dagger

import com.ysun.gnbmanager.base.rest.RetrofitClient
import com.ysun.gnbmanager.main.repository.datasources.PersistenceDataSource
import com.ysun.gnbmanager.main.repository.datasources.NetworkDataSource
import dagger.Module
import dagger.Provides

@Module
class DataSourceModule {

    @Provides
    fun providesNetworkDataSource(retrofitClient: RetrofitClient) : NetworkDataSource {
        return retrofitClient.client.create(NetworkDataSource::class.java)
    }

    @Provides
    fun providesPersistenceDataSource() : PersistenceDataSource {
        return PersistenceDataSource()
    }
}