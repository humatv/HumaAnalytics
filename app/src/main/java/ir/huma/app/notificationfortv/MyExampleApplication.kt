package ir.huma.app.notificationfortv

import android.app.Application
import ir.huma.notificationlibrary.AnalyticsApplication


class MyExampleApplication : AnalyticsApplication(
    isBuildConfigDebug = BuildConfig.DEBUG,
    buildConfigFlavor = BuildConfig.FLAVOR) {
}