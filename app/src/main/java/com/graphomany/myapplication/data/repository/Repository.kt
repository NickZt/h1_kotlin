package ua.zt.mezon.graphomania.fsmandstrategydemo.datasources

import com.graphomany.myapplication.data.models.CounterModel
import com.graphomany.myapplication.domain.usecase.UseCase


class Repository : UseCase {


    override fun iniLoad() {
//        its empty and will be expanded in next part of tuturial
    }

    override fun incrementEvenCounter() {
        evenCounter = CounterModel(evenCounter.count + 1);
    }

    override fun getCounter(): CounterModel {
        return counter
    }

    override fun getEvenCounter(): CounterModel {
        return evenCounter
    }

    override fun increment() {
        counter = CounterModel(counter.count + 1);
    }

    companion object {
        private var counter = CounterModel(0)
        private var evenCounter = CounterModel(0)
    }
}
