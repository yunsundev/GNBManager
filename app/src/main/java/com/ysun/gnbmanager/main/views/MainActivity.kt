package com.ysun.gnbmanager.main.views

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ysun.gnbmanager.main.repository.models.Rate
import com.ysun.gnbmanager.main.repository.models.Transaction
import com.ysun.gnbmanager.main.presenter.MainContract
import com.ysun.gnbmanager.R
import com.ysun.gnbmanager.base.views.activity.BaseActivity
import com.ysun.gnbmanager.dagger.AppComponent
import com.ysun.gnbmanager.main.views.adapter.TransactionsAdapter
import kotlinx.android.synthetic.main.activity_main.*
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
        recyclerView = findViewById(R.id.activity_main_recyclerView);
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

    override fun onRatesLoaded(rateList: List<Rate>) {

    }

    override fun onTransactionsLoaded(transactionList: Map<String, MutableList<Transaction>>) {
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = TransactionsAdapter(transactionList.keys.toList()) {
                item -> presenter.onItemClicked(item)
        }
    }

}