package ir.huma.notificationlibrary.data.model

import android.support.annotation.Keep

@Keep
data class AuthenticationRequestParameter (
    val macAddress:String?=null,
    val phone:String?=null
        )