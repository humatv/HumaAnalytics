package ir.huma.notificationlibrary

import android.app.Application
import android.content.Context

interface AnalyticsInitialization {
    fun initializeWebEngage(application: Application,webEngageLicenseKey:String?=null,isDebugMode:Boolean=false)
    fun setLoginUniqueIdForWebEngage(context: Context)
}