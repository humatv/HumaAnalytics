package ir.huma.notificationlibrary.utils.analytics

import com.webengage.sdk.android.Analytics
import ir.huma.notificationlibrary.data.model.UserAttributes

interface AnalyticsUtilInterface {
    fun loginUser(userManagerUserId:String?, isDevFlavor:Boolean, phoneNumber:String?=null, macAddress: String?=null)
    fun logoutUser()
    fun sendEvent(eventName: String, inputEventParameters: Map<String, Any>?=null)
    fun setUserAttribute(userAttributes: UserAttributes)

}