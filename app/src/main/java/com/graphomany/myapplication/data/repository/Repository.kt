package com.graphomany.myapplication.data.repository

import androidx.lifecycle.MutableLiveData
import com.graphomany.myapplication.data.models.CounterModel
import com.graphomany.myapplication.domain.usecase.UseCase


class Repository : UseCase {


    override fun iniLoad() {
        //added to demonstrate the initialization process and will be used in the h2 part
    }

    override fun incrementEvenCounter() {
        evenCounter.postValue(evenCounter.value?.count?.let { it -> CounterModel(it.plus(1)) })
    }

    override fun getEvenCounter(): MutableLiveData<CounterModel> {
        return evenCounter
    }

    override fun getCounter(): MutableLiveData<CounterModel> {
        return counter
    }

    override fun increment() {
        counter.postValue(counter.value?.count?.let { it -> CounterModel(it.plus(1)) })
    }

    companion object {
        private var counter = MutableLiveData(CounterModel(0))
        private var evenCounter = MutableLiveData(CounterModel(0))
    }
}
