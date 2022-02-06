package com.xendv.gifsobserver.base

interface BasePresenter<View> {
    fun attach(view: View)
    fun loadData()
    fun onButtonClick()
    fun onDestroy()
}