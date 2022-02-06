package com.xendv.gifsobserver.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface MainView: MvpView {
    fun updateView()
    fun showProgress(show: Boolean)
    fun getPreviousPost()
    fun getNextPost()
    fun showErrorMessage(localizedMessage: String?)
}