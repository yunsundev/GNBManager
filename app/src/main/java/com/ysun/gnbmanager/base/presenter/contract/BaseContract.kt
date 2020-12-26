package com.ysun.gnbmanager.base.presenter.contract

import com.ysun.gnbmanager.base.exceptions.AppException


interface BaseContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showError(exception: AppException)
    }

    interface Presenter {
        fun attachView(view: View)
    }

    interface Router {
    }
}