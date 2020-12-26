package com.ysun.gnbmanager.base.presenter.impl

import com.ysun.gnbmanager.base.presenter.contract.BaseContract
import com.ysun.gnbmanager.base.presenter.contract.BaseContract.Presenter

abstract class BasePresenterImpl : Presenter {
    protected var view: BaseContract.View? = null

    protected abstract fun init()

    override fun attachView(view: BaseContract.View) {
        this.view = view
        init()
    }
}