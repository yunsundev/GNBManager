package com.ysun.gnbmanager.detail.views.presenter.usecases.impl

import com.ysun.gnbmanager.detail.views.presenter.usecases.RequestRateUseCase
import com.ysun.gnbmanager.main.repository.RatesTransactionsRepository
import com.ysun.gnbmanager.main.repository.models.Rate
import io.reactivex.Observable

class RequestRateUseCaseImpl(val repository: RatesTransactionsRepository) : RequestRateUseCase {

    override fun requestRateData(): Observable<List<Rate>> {
        return repository.requestRates()
    }

}