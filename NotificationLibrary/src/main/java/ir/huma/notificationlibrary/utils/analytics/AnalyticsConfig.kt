package ir.huma.notificationlibrary.utils.analytics

import android.app.Application

interface AnalyticsConfig {
    fun initializeWebEngage(application: Application,webEngageLicenseKey:String?=null,isDebugMode:Boolean=false)

}