package com.ysun.gnbmanager.dagger

import com.ysun.gnbmanager.detail.views.presenter.usecases.ConvertedTransactionsUseCase
import com.ysun.gnbmanager.main.presenter.usecases.RelatedTransactionsUseCase
import com.ysun.gnbmanager.detail.views.presenter.usecases.RequestRateUseCase
import com.ysun.gnbmanager.detail.views.presenter.usecases.impl.ConvertedTransactionsUseCaseImpl
import com.ysun.gnbmanager.main.presenter.usecases.RequestTransactionUseCase
import com.ysun.gnbmanager.main.presenter.usecases.impl.RelatedTransactionsUseCaseImpl
import com.ysun.gnbmanager.detail.views.presenter.usecases.impl.RequestRateUseCaseImpl
import com.ysun.gnbmanager.main.presenter.usecases.impl.RequestTransactionUseCaseImpl
import com.ysun.gnbmanager.main.repository.RatesTransactionsRepository
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providesRequestTransactionUseCase(repository: RatesTransactionsRepository): RequestTransactionUseCase {
        return RequestTransactionUseCaseImpl(repository)
    }

    @Provides
    fun providesRequestRateUseCase(repository: RatesTransactionsRepository): RequestRateUseCase {
        return RequestRateUseCaseImpl(repository)
    }

    @Provides
    fun providesRelatedTransactionsUseCase(repository: RatesTransactionsRepository): RelatedTransactionsUseCase {
        return RelatedTransactionsUseCaseImpl(repository)
    }

    @Provides
    fun providesConvertedTransactionsUseCase() : ConvertedTransactionsUseCase {
        return ConvertedTransactionsUseCaseImpl()
    }
}