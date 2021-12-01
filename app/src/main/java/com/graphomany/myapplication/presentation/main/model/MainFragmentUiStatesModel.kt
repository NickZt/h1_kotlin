package com.graphomany.myapplication.presentation.main

import ua.zt.mezon.graphomania.fsmandstrategydemo.datasources.CounterModel

sealed class MainFragmentUiStatesModel {
    object Initial : MainFragmentUiStatesModel()
    data class LoadCounterPercentDataState(val percent: Int) : MainFragmentUiStatesModel()
    data class LoadErrorState(val errorCode: String) : MainFragmentUiStatesModel()
    object ListEmptyState : MainFragmentUiStatesModel()
    data class ListShowState(val listItem: ArrayList<CounterModel>) : MainFragmentUiStatesModel()
}
