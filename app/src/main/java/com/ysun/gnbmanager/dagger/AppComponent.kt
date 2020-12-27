package com.ysun.gnbmanager.dagger

import android.app.Application
import com.ysun.gnbmanager.detail.views.TransactionDetailActivity
import com.ysun.gnbmanager.main.views.MainActivity

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DataSourceModule::class,
        NetworkModule::class,
        PresenterModule::class,
        UseCaseModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {
    fun inject(application: Application?)

    fun inject(mainActivity: MainActivity)

    fun inject(transactionDetailActivity: TransactionDetailActivity)
}