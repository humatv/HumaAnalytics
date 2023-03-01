package ir.huma.app.notificationfortv

import android.app.Application
import ir.huma.notificationlibrary.AnalyticsApplication
import ir.huma.notificationlibrary.utils.analytics.AnalyticsUtil


class MyExampleApplication : AnalyticsApplication(
    isBuildConfigDebug = BuildConfig.DEBUG,
    buildConfigFlavor = BuildConfig.FLAVOR) {
    override fun onCreate() {
        super.onCreate()
        val isDevFlavor = BuildConfig.FLAVOR=="dev"

        /**
         * You acn login with "user_unique_Id_from_user_manager" which you got from
         * UserManager Server
         * it's recommend to pass userManagerUserId */
//        AnalyticsUtil.loginUser(userManagerUserId = "user_unique_Id_from_user_manager",isDevFlavor)


        /**
         * Or You acn login with user's "phoneNumber"
         * example : "09151646562"
         */
        AnalyticsUtil.loginUser(userManagerUserId = null,phoneNumber = "09151646562", isDevFlavor = isDevFlavor, )


        /**
         * Or You acn login with "device mac Address" which you got from
         * UserManager Server
         * it's not Recommended*/
//        AnalyticsUtil.loginUser(userManagerUserId = null, macAddress = "4f:54:23:fs:50", isDevFlavor = isDevFlavor, )

    }
}