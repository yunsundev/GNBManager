package com.ysun.gnbmanager.dagger

import android.content.Context
import android.content.SharedPreferences
import com.ysun.gnbmanager.base.rest.RetrofitClient
import com.ysun.gnbmanager.main.repository.datasources.NetworkDataSource
import dagger.Module
import dagger.Provides

@Module
class DataSourceModule {

    @Provides
    fun providesNetworkDataSource(retrofitClient: RetrofitClient) : NetworkDataSource {
        return retrofitClient.client.create(NetworkDataSource::class.java)
    }

    /*
    @Provides
    fun providesCacheDataSource(context : Context) : CacheDataSource {
        sharedPreferences.
        return CacheDataSource()
    }*/

}