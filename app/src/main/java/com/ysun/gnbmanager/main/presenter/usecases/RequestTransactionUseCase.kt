package com.ysun.gnbmanager.main.presenter.usecases

import com.ysun.gnbmanager.main.repository.models.Transaction
import io.reactivex.Observable

interface RequestTransactionUseCase {
    fun requestTransactionData(): Observable<Map<String, MutableList<Transaction>>>
}