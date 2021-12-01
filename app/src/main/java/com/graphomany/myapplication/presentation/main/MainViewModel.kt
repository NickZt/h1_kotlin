package com.graphomany.myapplication.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.graphomany.myapplication.data.models.CounterModel
import com.graphomany.myapplication.data.repository.Repository
import com.graphomany.myapplication.domain.usecase.UseCase
import com.graphomany.myapplication.presentation.main.model.MainFragmentUiStatesModel


class MainViewModel : ViewModel() {

    val viewState: MutableLiveData<MainFragmentUiStatesModel> = MutableLiveData()
    private lateinit var useCase: UseCase

    fun initialize() {
        viewState.value = MainFragmentUiStatesModel.Odd
        useCase = Repository()
        useCase.iniLoad()

    }

    fun getCounterLiveData(): LiveData<CounterModel> {
        return useCase.getCounter()
    }

    fun getEvenCounterLiveData(): LiveData<CounterModel> {
        return useCase.getEvenCounter()
    }

    fun getIsEvenLiveData(): LiveData<Boolean> {
        return useCase.isEven()
    }

    private fun resetState() {
        viewState.postValue(MainFragmentUiStatesModel.Odd)
    }

    private fun incrementEvenCounter() {
        useCase.incrementEvenCounter()
    }

    private fun increment() {
        useCase.increment()
    }


    fun onFabPressed() {
        increment()
    }

    private fun setEvenState() {
        incrementEvenCounter()
        viewState.postValue(MainFragmentUiStatesModel.Even)
    }

    fun setStates(it: Boolean) {
        if (it) {
            setEvenState()
        } else resetState()
    }
}