package ir.huma.notificationlibrary.utils.personalizition.webengage.models.raw

import androidx.annotation.Keep
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.PersonalizationModel

@Keep
data class RawData(
    val value : HashMap<String,Any>?,
): PersonalizationModel
