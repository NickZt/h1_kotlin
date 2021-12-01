package com.graphomany.myapplication.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.graphomany.myapplication.data.models.CounterModel


interface UseCase {
    fun iniLoad()

    fun incrementEvenCounter()

    fun isEven(): LiveData<Boolean> {
        return getCounter().map(fun(it: CounterModel): Boolean {
            return (it.count != 0) && it.count % 2 == 0
        })
    }

    fun getCounter(): LiveData<CounterModel>

    fun getEvenCounter(): LiveData<CounterModel>

    fun increment()
}