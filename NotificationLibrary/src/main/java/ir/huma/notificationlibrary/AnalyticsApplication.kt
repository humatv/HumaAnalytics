package ir.huma.notificationlibrary

import android.app.Application
import com.webengage.sdk.android.WebEngage
import ir.huma.notificationlibrary.common.Constants.WEB_ENGAGE_LICENSE_CODE
import ir.huma.notificationlibrary.utils.Utils

abstract class AnalyticsApplication(
    private val webEngageLicensesKey:String=WEB_ENGAGE_LICENSE_CODE,
    private val analyticsInitialization: AnalyticsInitialization = AnalyticsInitializationImp()
):Application() {
    override fun onCreate() {
        super.onCreate()
        analyticsInitialization.apply {

            initializeWebEngage(this@AnalyticsApplication,webEngageLicensesKey)
            setLoginUniqueIdForWebEngage(this@AnalyticsApplication.baseContext)
        }

    }

}