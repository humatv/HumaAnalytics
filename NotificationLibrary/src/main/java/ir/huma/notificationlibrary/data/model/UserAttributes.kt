package ir.huma.notificationlibrary.data.model

import android.support.annotation.Keep

@Keep
data class UserAttributes(
    val firstName:String?=null,
    val lastName: String?=null,
    val phoneNumber: String?=null,
    val city: String?=null,
    val email: String?=null,
    val avatarUrl: String?=null,
)