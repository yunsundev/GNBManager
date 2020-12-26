package com.ysun.gnbmanager.main.presenter.usecases.impl

import com.ysun.gnbmanager.main.presenter.usecases.RequestRateUseCase
import com.ysun.gnbmanager.main.repository.NetworkRepository
import com.ysun.gnbmanager.main.repository.models.Rate
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RequestRateUseCaseImpl(val repository: NetworkRepository) : RequestRateUseCase {

    override fun requestRateData(): Observable<List<Rate>> {
        return repository.requestRates()
    }

}