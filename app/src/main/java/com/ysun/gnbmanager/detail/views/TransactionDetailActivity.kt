package com.ysun.gnbmanager.detail.views

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ysun.gnbmanager.R
import com.ysun.gnbmanager.base.views.activity.BaseActivity
import com.ysun.gnbmanager.base.views.customviews.BaseTextView
import com.ysun.gnbmanager.commons.Constants
import com.ysun.gnbmanager.dagger.AppComponent
import com.ysun.gnbmanager.detail.views.adapter.TransactionsDetailsAdapter
import com.ysun.gnbmanager.detail.views.presenter.TransactionDetailContract
import com.ysun.gnbmanager.main.presenter.MainContract
import com.ysun.gnbmanager.main.repository.models.Rate
import com.ysun.gnbmanager.main.repository.models.Transaction
import javax.inject.Inject

class TransactionDetailActivity : BaseActivity(), TransactionDetailContract.View {

    @Inject
    lateinit var presenter: TransactionDetailContract.Presenter

    private lateinit var transactionList: ArrayList<Transaction>
    private lateinit var rateList: ArrayList<Rate>

    private var recyclerView: RecyclerView? = null
    private var title: BaseTextView? = null

    override val layoutResId: Int
        get() = R.layout.activity_transaction_detail

    override fun initPresenter() {
        presenter.attachView(this)
    }

    override fun bindViews() {
        recyclerView = findViewById(R.id.activity_transaction_detail_recyclerView)
        title = findViewById(R.id.activity_transaction_detail_title)
    }

    override fun init(extras: Bundle?) {
        if (extras?.get(Constants.PARAM_TRANSACTIONS_LIST) != null
            && extras.get(Constants.PARAM_RATE_LIST) != null
        ) {
            transactionList =
                extras.get(Constants.PARAM_TRANSACTIONS_LIST) as ArrayList<Transaction>
            rateList = extras.get(Constants.PARAM_RATE_LIST) as ArrayList<Rate>
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.calculateTransactionTotalAndConvertRates(rateList, transactionList)
    }

    override fun injectView(appComponent: AppComponent?) {
        appComponent?.inject(this)
    }

    override fun destroyInstances() {

    }

    override fun showActionBar(): Boolean {
        return true
    }

    override fun getActionBarTitle(): String {
        return transactionList[0].id
    }

    override fun onTotalCalculated(total: Double) {
        title?.text = getString(R.string.detail_total, total)
    }

    override fun onTransactionRatesConverted(transactions: List<Transaction>) {
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter =
            TransactionsDetailsAdapter(transactions)
    }
}