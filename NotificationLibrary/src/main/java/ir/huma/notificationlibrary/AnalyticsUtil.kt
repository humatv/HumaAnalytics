package ir.huma.notificationlibrary

import com.webengage.sdk.android.Analytics
import com.webengage.sdk.android.WebEngage
import java.util.InputMismatchException
import java.util.Objects

object AnalyticsUtil {
    fun getWebEngageAnalytics(): Analytics? {
        return WebEngage.get().analytics()
    }

    fun sendEvent(eventName:String,arguments:Map<String,Any>?=null,option: Analytics.Options?=null){
        if (eventName.startsWith("we_")||eventName.startsWith("we_"))
            throw InputMismatchException("Event name must not start with we_")
        getWebEngageAnalytics()?.track(eventName,arguments,option)

    }
}