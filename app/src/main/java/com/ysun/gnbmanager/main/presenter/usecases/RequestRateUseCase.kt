package com.ysun.gnbmanager.main.presenter.usecases

import com.ysun.gnbmanager.main.repository.models.Rate
import io.reactivex.Observable

interface RequestRateUseCase {
    fun requestRateData() : Observable<List<Rate>>
}