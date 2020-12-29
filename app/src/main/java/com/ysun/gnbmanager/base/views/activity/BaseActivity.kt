package com.ysun.gnbmanager.base.views.activity

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ysun.gnbmanager.Application
import com.ysun.gnbmanager.R
import com.ysun.gnbmanager.base.exceptions.AppException
import com.ysun.gnbmanager.base.presenter.contract.BaseContract
import com.ysun.gnbmanager.base.views.dialog.LoadingDialog
import com.ysun.gnbmanager.dagger.AppComponent


abstract class BaseActivity : AppCompatActivity(), BaseContract.View, BaseContract.Router {

    @get:LayoutRes
    protected abstract val layoutResId: Int

    protected abstract fun initPresenter()

    protected abstract fun bindViews()

    protected abstract fun init(extras: Bundle?)

    protected abstract fun injectView(appComponent: AppComponent?)

    protected abstract fun destroyInstances()

    protected abstract fun showActionBar(): Boolean

    protected abstract fun getActionBarTitle(): String

    private var loadingDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        initInjection()
        initPresenter()
        bindViews()
        init(intent.extras)

        configureActionBar(showActionBar())
    }

    override fun onDestroy() {
        destroyInstances()
        super.onDestroy()
    }

    private fun initInjection() {
        injectView((application as Application).component)
    }

    private fun configureActionBar(showActionBar: Boolean) {
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            actionBar.setCustomView(R.layout.abs_layout)
            val textView = actionBar.customView.findViewById<TextView>(R.id.actionBar_title)
            textView.text = getActionBarTitle()
            actionBar.setDisplayHomeAsUpEnabled(showActionBar)
        }
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}