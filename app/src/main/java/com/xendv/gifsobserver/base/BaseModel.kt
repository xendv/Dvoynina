package com.xendv.gifsobserver.base

interface BaseModel {
    interface OnFinishedListener {
        fun onResultSuccess()
        fun onResultFail(error: String)
    }

    fun getNextPost(onFinishedListener: OnFinishedListener)
}