package com.ysun.gnbmanager.base.views.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import com.ysun.gnbmanager.R

class LoadingDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val inflateView: View =
            inflater.inflate(R.layout.base_loading_dialog, findViewById(R.id.base_loading_dialogRL))
        window!!.setBackgroundDrawableResource(R.color.transparent)
        setContentView(inflateView)
    }

}