package com.ysun.gnbmanager.main.presenter

import com.ysun.gnbmanager.base.presenter.contract.BaseContract
import com.ysun.gnbmanager.main.repository.models.Rate
import com.ysun.gnbmanager.main.repository.models.Transaction

interface MainContract : BaseContract {

    interface View : BaseContract.View {
        fun onRatesLoaded(rateList: List<Rate>)
        fun onTransactionsLoaded(transactionList: Map<String, MutableList<Transaction>>)
    }

    interface Presenter: BaseContract.Presenter {
        fun requestRates()
        fun requestTransactions()
        fun onItemClicked(item: String)
    }

}