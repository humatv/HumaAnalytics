package ir.huma.notificationlibrary.utils.personalizition.webengage.models.footer

import androidx.annotation.Keep
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.PersonalizationModel

@Keep
data class FooterData(
    val title: String? ,
    val description: String? ,
    val linkUrl: String? ,
    val senderPackageName: String? ,
    ): PersonalizationModel{

    }
