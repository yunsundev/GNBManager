package com.ysun.gnbmanager.dagger

import android.content.Context
import com.ysun.gnbmanager.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {

    @Provides
    @Singleton
    fun providesApplication() = application

    @Provides
    fun providesContext(application: Application): Context {
        return application.applicationContext
    }
}