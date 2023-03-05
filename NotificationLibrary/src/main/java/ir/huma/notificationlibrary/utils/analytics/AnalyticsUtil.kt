package ir.huma.notificationlibrary.utils.analytics

import android.os.Bundle
import com.webengage.sdk.android.Analytics
import ir.huma.notificationlibrary.data.model.UserAttributes
import ir.huma.notificationlibrary.utils.analytics.webengage.WebEngageAnalyticsUtil

object AnalyticsUtil:AnalyticsUtilInterface {
    private val webEngageAnalyticsUtil :AnalyticsUtilInterface =WebEngageAnalyticsUtil()
    override fun loginUser(
        userManagerUserId: String?,
        isDevFlavor: Boolean,
        phoneNumber: String?,
        macAddress: String?,
    ) {

        webEngageAnalyticsUtil.loginUser(
            userManagerUserId= userManagerUserId,
        isDevFlavor = isDevFlavor,
        phoneNumber= phoneNumber,
        macAddress = macAddress)
    }

    override fun logoutUser() {
        webEngageAnalyticsUtil.logoutUser()
    }

    override fun sendEvent(eventName: String, inputEventParameters: Map<String, Any>?) {
        webEngageAnalyticsUtil.sendEvent(
            eventName =eventName ,
            inputEventParameters = inputEventParameters,

        )
    }

    override fun sendEvent(eventName: String, inputEventParameters: Bundle?) {
        webEngageAnalyticsUtil.sendEvent(
            eventName =eventName ,
            inputEventParameters = inputEventParameters)
    }

    override fun setUserAttribute(userAttributes: UserAttributes) {
        webEngageAnalyticsUtil.setUserAttribute(userAttributes=userAttributes)
    }
}