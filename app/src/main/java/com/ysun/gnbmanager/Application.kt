package com.ysun.gnbmanager

import android.app.Application
import com.ysun.gnbmanager.dagger.*

class Application : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .dataSourceModule(DataSourceModule())
            .repositoryModule(RepositoryModule())
            .presenterModule(PresenterModule())
            .networkModule(NetworkModule())
            .useCaseModule(UseCaseModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

}