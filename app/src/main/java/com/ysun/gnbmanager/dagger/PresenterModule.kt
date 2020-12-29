package com.ysun.gnbmanager.dagger

import com.ysun.gnbmanager.detail.views.presenter.TransactionDetailContract
import com.ysun.gnbmanager.detail.views.presenter.impl.TransactionDetailPresenter
import com.ysun.gnbmanager.detail.views.presenter.usecases.ConvertedTransactionsUseCase
import com.ysun.gnbmanager.main.presenter.MainContract
import com.ysun.gnbmanager.main.presenter.impl.MainPresenter
import com.ysun.gnbmanager.main.presenter.usecases.RelatedTransactionsUseCase
import com.ysun.gnbmanager.detail.views.presenter.usecases.RequestRateUseCase
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
        return MainPresenter(
            requestRateUseCase,
            requestTransactionUseCase,
            relatedTransactionsUseCase
        )
    }

    @Provides
    fun providesTransactionDetailPresenter(convertedTransactionsUseCase: ConvertedTransactionsUseCase)
            : TransactionDetailContract.Presenter {
        return TransactionDetailPresenter(convertedTransactionsUseCase)
    }
}
