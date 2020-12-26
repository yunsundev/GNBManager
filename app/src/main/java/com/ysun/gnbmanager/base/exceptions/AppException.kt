package com.ysun.gnbmanager.base.exceptions

import com.ysun.gnbmanager.R


class AppException(private val type: Type?, message: String?) : Exception(message) {

    val exceptionMessage : Int
        get() {
            return when (type){
                Type.NETWORK_ERROR -> R.string.error_network_message
                else -> R.string.error_unknown_message
            }
        }

    enum class Type {
        NETWORK_ERROR
    }

}