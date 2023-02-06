package ir.huma.notificationlibrary

import android.app.Application


abstract class AnalyticsApplication(
    private val webEngageLicensesKey:String?=null,
    private val analyticsInitialization: AnalyticsInitialization = AnalyticsInitializationImp(),
    private val isBuildConfigDebug: Boolean,
    private val buildConfigFlavor: String
):Application() {
    override fun onCreate() {
        super.onCreate()
        analyticsInitialization.apply {
            val isDebugMode =if(isBuildConfigDebug) true else {
                buildConfigFlavor != "prod"
            }
            initializeWebEngage(this@AnalyticsApplication,webEngageLicensesKey,isDebugMode)
            setLoginUniqueIdForWebEngage(this@AnalyticsApplication.baseContext)
        }

    }

}