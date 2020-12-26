package com.ysun.gnbmanager.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(layoutRes: Int):View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)