package com.ysun.gnbmanager.main.presenter.impl

import com.ysun.gnbmanager.base.presenter.impl.BasePresenterImpl
import com.ysun.gnbmanager.main.presenter.MainContract
import com.ysun.gnbmanager.main.presenter.usecases.RelatedTransactionsUseCase
import com.ysun.gnbmanager.detail.views.presenter.usecases.RequestRateUseCase
import com.ysun.gnbmanager.main.presenter.usecases.RequestTransactionUseCase
import com.ysun.gnbmanager.main.repository.models.Rate
import com.ysun.gnbmanager.main.repository.models.Transaction
import io.reactivex.observers.DisposableObserver

class MainPresenter(
    private val requestRateUseCase: RequestRateUseCase,
    private val requestTransactionUseCase: RequestTransactionUseCase,
    private val relatedTransactionsUseCase: RelatedTransactionsUseCase
) : BasePresenterImpl(), MainContract.Presenter {

    private lateinit var rateList: List<Rate>

    override fun init() {

    }

    override fun requestRates() {
        requestRateUseCase.requestRateData()
            .subscribe(createRatesObserver())
    }

    override fun requestTransactions() {
        requestTransactionUseCase.requestTransactionData()
            .subscribe(createTransactionsObserver())
    }

    override fun onTransactionClicked(transactionId: String) {
        relatedTransactionsUseCase.findTransactionList(transactionId)
            .subscribe(createRelatedTransactionsObserver())
    }

    private fun createRatesObserver(): DisposableObserver<List<Rate>> {
        val view = (view as MainContract.View)
        view.showLoading()
        return object : DisposableObserver<List<Rate>>() {

            override fun onNext(rateList: List<Rate>) {
                this@MainPresenter.rateList = rateList
            }

            override fun onComplete() {
                view.hideLoading()
            }

            override fun onError(e: Throwable) {
                view.hideLoading()
            }
        }
    }

    private fun createTransactionsObserver(): DisposableObserver<Map<String, MutableList<Transaction>>> {
        val view = (view as MainContract.View)
        view.showLoading()
        return object : DisposableObserver<Map<String, MutableList<Transaction>>>() {

            override fun onNext(transactionsMap: Map<String, MutableList<Transaction>>) {
                relatedTransactionsUseCase.saveTransactions(transactionsMap)
                view.onTransactionsLoaded(transactionsMap)
            }

            override fun onComplete() {
                view.hideLoading()
            }

            override fun onError(e: Throwable) {
                view.hideLoading()
            }
        }
    }

    private fun createRelatedTransactionsObserver(): DisposableObserver<List<Transaction>> {
        val view = (view as MainContract.View)
        view.showLoading()
        return object : DisposableObserver<List<Transaction>>() {

            override fun onNext(transactionList: List<Transaction>) {
                view.onRelatedTransactionListLoaded(this@MainPresenter.rateList, transactionList)
            }

            override fun onComplete() {
                view.hideLoading()
            }

            override fun onError(e: Throwable) {
                view.hideLoading()
            }
        }
    }
}