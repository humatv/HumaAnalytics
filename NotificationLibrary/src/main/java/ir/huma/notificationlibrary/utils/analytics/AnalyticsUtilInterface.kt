package ir.huma.notificationlibrary.utils.analytics

import android.os.Bundle
import ir.huma.notificationlibrary.data.model.UserAttributes
import java.util.Date

interface AnalyticsUtilInterface {
    fun loginUser(userManagerUserId:String?, isDevFlavor:Boolean, phoneNumber:String?=null, macAddress: String?=null)
    fun logoutUser()
    fun sendEvent(eventName: String)
    fun sendEvent(eventName: String, inputEventParameters: Map<String, Any>?=null)
    fun sendEvent(eventName: String, inputEventParameters: Bundle?=null)
    fun setUserAttribute(userAttributes: UserAttributes)

    fun setAttribute(attributeName: String, value: String?)

    fun setAttribute(attributeName: String, value: Boolean?)

    fun setAttribute(attributeName: String, value: Number?)

    fun setAttribute(attributeName: String, value: Date?)

    fun screenNavigated(screenName: String, parameters: Map<String?, Any?>?=null)

    fun setScreenData(parameters: Map<String?, Any?>?)

}