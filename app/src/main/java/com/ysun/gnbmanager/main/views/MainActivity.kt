package com.ysun.gnbmanager.main.views

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ysun.gnbmanager.R
import com.ysun.gnbmanager.base.views.activity.BaseActivity
import com.ysun.gnbmanager.commons.Constants
import com.ysun.gnbmanager.dagger.AppComponent
import com.ysun.gnbmanager.detail.views.TransactionDetailActivity
import com.ysun.gnbmanager.main.presenter.MainContract
import com.ysun.gnbmanager.main.repository.models.Rate
import com.ysun.gnbmanager.main.repository.models.Transaction
import com.ysun.gnbmanager.main.views.adapter.TransactionsAdapter
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    private var recyclerView: RecyclerView? = null

    override val layoutResId: Int
        get() = R.layout.activity_main

    override fun initPresenter() {
        presenter.attachView(this)
    }

    override fun bindViews() {
        recyclerView = findViewById(R.id.activity_main_recyclerView)
    }

    override fun init(extras: Bundle?) {
        presenter.requestRates()
        presenter.requestTransactions()
    }

    override fun injectView(appComponent: AppComponent?) {
        appComponent?.inject(this)
    }

    override fun destroyInstances() {

    }

    override fun showActionBar(): Boolean {
        return false
    }

    override fun getActionBarTitle(): String {
        return getString(R.string.app_name)
    }

    override fun onTransactionsLoaded(transactionList: Map<String, MutableList<Transaction>>) {
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter =
            TransactionsAdapter(transactionList.keys.toList()) { transactionId ->
                presenter.onTransactionClicked(transactionId)
            }
    }

    override fun onRelatedTransactionListLoaded(rateList: List<Rate>, transactionList: List<Transaction>) {
        val extras = Bundle()
        extras.putSerializable(Constants.PARAM_RATE_LIST, ArrayList(rateList))
        extras.putSerializable(Constants.PARAM_TRANSACTIONS_LIST, ArrayList(transactionList))
        navigateToActivityWithBundle(TransactionDetailActivity::class.java, extras)
    }

}