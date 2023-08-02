package ir.huma.notificationlibrary

import android.app.Application
import ir.huma.notificationlibrary.utils.analytics.AnalyticsConfig
import ir.huma.notificationlibrary.utils.analytics.webengage.WebEngageConfig
import ir.huma.notificationlibrary.utils.personalizition.webengage.WebengagePersonalizationConfig


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
            WebengagePersonalizationConfig.initPersonalization()

        }

    }

}