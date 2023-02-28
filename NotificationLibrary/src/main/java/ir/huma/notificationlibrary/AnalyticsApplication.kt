package ir.huma.notificationlibrary

import android.app.Application
import ir.huma.notificationlibrary.utils.AnalyticsConfig
import ir.huma.notificationlibrary.utils.webengage.WebEngageConfig


abstract class AnalyticsApplication(
    private val isBuildConfigDebug: Boolean,
    private val buildConfigFlavor: String,
    private val analyticsConfig: AnalyticsConfig = WebEngageConfig(),
    private val webEngageLicensesKey: String? = null,
) : Application() {
    override fun onCreate() {
        super.onCreate()
        analyticsConfig.apply {
            val isDebugMode = if (isBuildConfigDebug) true
            else {
                buildConfigFlavor != "prod"
            }

            initializeWebEngage(this@AnalyticsApplication, webEngageLicensesKey, isDebugMode)
        }

    }

}