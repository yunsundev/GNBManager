package com.ysun.gnbmanager.dagger

import com.ysun.gnbmanager.main.presenter.usecases.RequestRateUseCase
import com.ysun.gnbmanager.main.presenter.usecases.RequestTransactionUseCase
import com.ysun.gnbmanager.main.presenter.usecases.impl.RequestRateUseCaseImpl
import com.ysun.gnbmanager.main.presenter.usecases.impl.RequestTransactionUseCaseImpl
import com.ysun.gnbmanager.main.repository.NetworkRepository
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providesRequestTransactionUseCase(repository: NetworkRepository) : RequestTransactionUseCase{
        return RequestTransactionUseCaseImpl(repository)
    }

    @Provides
    fun providesRequestRateUseCase(repository: NetworkRepository) : RequestRateUseCase {
        return RequestRateUseCaseImpl(repository)
    }
}