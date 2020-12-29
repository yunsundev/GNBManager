package com.ysun.gnbmanager.detail.views.presenter

import com.ysun.gnbmanager.base.presenter.contract.BaseContract
import com.ysun.gnbmanager.main.repository.models.Rate
import com.ysun.gnbmanager.main.repository.models.Transaction

interface TransactionDetailContract : BaseContract{

    interface View : BaseContract.View {
        fun onTotalCalculated(total: Double)
        fun onTransactionRatesConverted(transaction: List<Transaction>)
    }

    interface Presenter: BaseContract.Presenter {
        fun calculateTransactionTotalAndConvertRates(rateList: List<Rate>, transactionList: List<Transaction>)
    }
}