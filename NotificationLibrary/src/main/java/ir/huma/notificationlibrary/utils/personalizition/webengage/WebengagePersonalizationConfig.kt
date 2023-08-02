package ir.huma.notificationlibrary.utils.personalizition.webengage

import com.webengage.personalization.WEPersonalization
import ir.huma.notificationlibrary.utils.personalizition.PersonalizationConfig

object WebengagePersonalizationConfig: PersonalizationConfig {
    override fun initPersonalization() {
        WEPersonalization.Companion.get().init()
    }
}