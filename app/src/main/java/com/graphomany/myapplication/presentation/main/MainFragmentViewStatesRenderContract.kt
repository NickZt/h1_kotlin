package com.graphomany.myapplication.presentation.main

import com.graphomany.myapplication.presentation.main.model.MainFragmentUiStatesModel

interface MainFragmentViewStatesRenderContract {
    fun render(viewState: MainFragmentUiStatesModel) {
        when (viewState) {
            MainFragmentUiStatesModel.Even -> {
                showEvenState()
            }
            MainFragmentUiStatesModel.Odd -> {
                showOddState()
            }
        }
    }

    fun showEvenState()
    fun showOddState()
}
