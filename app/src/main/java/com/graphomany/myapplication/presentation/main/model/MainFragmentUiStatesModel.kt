package com.graphomany.myapplication.presentation.main.model

sealed class MainFragmentUiStatesModel {
    object Odd : MainFragmentUiStatesModel()
    object Even : MainFragmentUiStatesModel()
}
