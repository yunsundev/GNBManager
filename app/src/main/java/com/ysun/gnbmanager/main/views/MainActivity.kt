package com.ysun.gnbmanager.main.views

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ysun.gnbmanager.R
import com.ysun.gnbmanager.base.views.activity.BaseActivity
import com.ysun.gnbmanager.dagger.AppComponent
import com.ysun.gnbmanager.main.presenter.MainContract
import com.ysun.gnbmanager.main.repository.models.Transaction
import com.ysun.gnbmanager.main.views.adapter.TransactionsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    private val recyclerView: RecyclerView = activity_main_recyclerView

    override val layoutResId: Int
        get() = R.layout.activity_main

    override fun initPresenter() {
        presenter.attachView(this)
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

    override fun onTransactionsLoaded(transactionList: Map<String, MutableList<Transaction>>) {
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = TransactionsAdapter(transactionList.keys.toList()) {
                transactionId -> presenter.onTransactionClicked(transactionId)
        }
    }

    override fun onRelatedTransactionListLoaded(transactionList: List<Transaction>) {
        for (trans in transactionList){
            Log.d("YUUN", trans.id + " " + trans.amount)
        }
    }

}