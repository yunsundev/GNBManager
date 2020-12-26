package com.ysun.gnbmanager.dagger

import com.ysun.gnbmanager.base.rest.RetrofitClient

import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun providesRetrofitClient(): RetrofitClient {
        return RetrofitClient()
    }
}