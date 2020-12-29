package com.ysun.gnbmanager.detail.views.presenter.impl

import com.ysun.gnbmanager.base.presenter.impl.BasePresenterImpl
import com.ysun.gnbmanager.detail.views.presenter.TransactionDetailContract
import com.ysun.gnbmanager.detail.views.presenter.usecases.ConvertedTransactionsUseCase
import com.ysun.gnbmanager.main.presenter.MainContract
import com.ysun.gnbmanager.main.repository.models.Rate
import com.ysun.gnbmanager.main.repository.models.Transaction

class TransactionDetailPresenter(private val convertedTransactionsUseCase: ConvertedTransactionsUseCase) :
    BasePresenterImpl(), TransactionDetailContract.Presenter {

    override fun init() {

    }

    override fun calculateTransactionTotalAndConvertRates(
        rateList: List<Rate>,
        transactionList: List<Transaction>
    ) {
        val list = convertedTransactionsUseCase.convertTransactionRates(rateList, transactionList)
        val view = (view as TransactionDetailContract.View)
        view.onTotalCalculated(convertedTransactionsUseCase.calculateTotalTransactionsInEur(list))
        view.onTransactionRatesConverted(list)
    }
}