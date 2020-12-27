package com.ysun.gnbmanager.base.views.activity

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ysun.gnbmanager.Application
import com.ysun.gnbmanager.R
import com.ysun.gnbmanager.base.presenter.contract.BaseContract
import com.ysun.gnbmanager.base.exceptions.AppException
import com.ysun.gnbmanager.base.views.dialog.LoadingDialog
import com.ysun.gnbmanager.dagger.AppComponent


abstract class BaseActivity : AppCompatActivity(), BaseContract.View, BaseContract.Router {

    @get:LayoutRes
    protected abstract val layoutResId: Int

    protected abstract fun initPresenter()

    protected abstract fun init(extras: Bundle?)

    protected abstract fun injectView(appComponent: AppComponent?)

    protected abstract fun destroyInstances()

    private var loadingDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        initInjection()
        initPresenter()
        bindViews()
        init(intent.extras)
    }

    override fun onDestroy() {
        destroyInstances()
        super.onDestroy()
    }

    private fun initInjection() {
        injectView((application as Application).component)
    }

    protected fun navigateToActivity(klazz: Class<out BaseActivity?>?) {
        navigateToActivityWithBundle(klazz, null)
    }

    protected fun navigateToActivityWithBundle(klazz: Class<out BaseActivity?>?, args: Bundle?) {
        val intent = Intent(this@BaseActivity, klazz)
        if (args != null) {
            intent.putExtras(args)
        }
        startActivity(intent)
    }

    override fun showLoading() {
        if (loadingDialog == null) {
            loadingDialog = LoadingDialog(this)
            (loadingDialog as LoadingDialog).show()
        }
    }

    override fun hideLoading() {
        loadingDialog?.hide()
    }

    override fun showError(exception: AppException) {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.error_title))
            .setMessage(getString(exception.exceptionMessage))
            .show()
    }

}