package com.ysun.gnbmanager.dagger

import com.ysun.gnbmanager.main.presenter.MainContract
import com.ysun.gnbmanager.main.presenter.impl.MainPresenter
import com.ysun.gnbmanager.main.presenter.usecases.RelatedTransactionsUseCase
import com.ysun.gnbmanager.main.presenter.usecases.RequestRateUseCase
import com.ysun.gnbmanager.main.presenter.usecases.RequestTransactionUseCase
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun providesMainPresenter(
        requestRateUseCase: RequestRateUseCase,
        requestTransactionUseCase: RequestTransactionUseCase,
        relatedTransactionsUseCase: RelatedTransactionsUseCase
    ): MainContract.Presenter {
        return MainPresenter(requestRateUseCase, requestTransactionUseCase, relatedTransactionsUseCase)
    }
}
