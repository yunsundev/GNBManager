package com.ysun.gnbmanager.detail.views

import android.os.Bundle
import com.ysun.gnbmanager.R
import com.ysun.gnbmanager.base.views.activity.BaseActivity
import com.ysun.gnbmanager.dagger.AppComponent

class TransactionDetailActivity : BaseActivity() {

    override val layoutResId: Int
        get() = R.layout.activity_transaction_detail

    override fun initPresenter() {
        
    }

    override fun init(extras: Bundle?) {

    }

    override fun injectView(appComponent: AppComponent?) {
        appComponent?.inject(this)
    }

    override fun destroyInstances() {

    }
}