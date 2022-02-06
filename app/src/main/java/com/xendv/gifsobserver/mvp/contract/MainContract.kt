package com.xendv.gifsobserver.mvp.contract

import com.xendv.gifsobserver.base.BaseContract

class MainContract {
    interface IView: BaseContract.View {
        fun showProgress(toShow: Boolean)
        fun getDataSuccess()
        fun getDataFailed()
    }

    interface IPresenter: BaseContract.Presenter<MainContract.IView> {
        fun loadNewPost()
        fun onNextClick()
        fun onDestroy()
    }

    interface IModel {
        interface OnFinishedListener {
            fun onResultSuccess()
            fun onResultFail(error: String)
        }

        fun getDataAPI(onFinishedListener: OnFinishedListener)
    }
}