package ir.huma.notificationlibrary.utils.analytics.webengage

import android.app.Application
import com.webengage.sdk.android.WebEngageActivityLifeCycleCallbacks
import com.webengage.sdk.android.WebEngageConfig
import ir.huma.notificationlibrary.common.Constants
import ir.huma.notificationlibrary.utils.analytics.AnalyticsConfig


class WebEngageConfig: AnalyticsConfig {
    override fun initializeWebEngage(application: Application, webEngageLicenseKey: String?,isDebugMode:Boolean) {

       val webEngageLicenseKeyForConfig = webEngageLicenseKey
           ?: if (isDebugMode){
               Constants.WEB_ENGAGE_TEST_LICENSE_CODE
           } else{
               Constants.WEB_ENGAGE_LICENSE_CODE
           }
        val webEngageConfig = WebEngageConfig.Builder()
            .setWebEngageKey(webEngageLicenseKeyForConfig)
            .setDebugMode(isDebugMode)
            .build()
        application.registerActivityLifecycleCallbacks(WebEngageActivityLifeCycleCallbacks(application,
            webEngageConfig))
    }


}