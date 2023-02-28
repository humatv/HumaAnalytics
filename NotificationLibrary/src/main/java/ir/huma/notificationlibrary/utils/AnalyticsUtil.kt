package ir.huma.notificationlibrary.utils

import com.webengage.sdk.android.Analytics
import ir.huma.notificationlibrary.data.model.UserAttributes

interface AnalyticsUtil {
    fun loginUser(userManagerUserId:String?, isDevFlavor:Boolean, phoneNumber:String?=null, macAddress: String?=null)
    fun logoutUser()
    fun sendEvent(eventName: String, inputEventParameters: Map<String, Any>?=null, option: Analytics.Options?=null)
    fun setUserAttribute(userAttributes: UserAttributes)

}