package ir.huma.notificationlibrary.utils.analytics

import android.os.Bundle
import com.webengage.sdk.android.Analytics
import ir.huma.notificationlibrary.data.model.UserAttributes

interface AnalyticsUtilInterface {
    fun loginUser(userManagerUserId:String?, isDevFlavor:Boolean, phoneNumber:String?=null, macAddress: String?=null)
    fun logoutUser()
    fun sendEvent(eventName: String, inputEventParameters: Map<String, Any>?=null)
    fun sendEvent(eventName: String, inputEventParameters: Bundle?=null)
    fun setUserAttribute(userAttributes: UserAttributes)

}