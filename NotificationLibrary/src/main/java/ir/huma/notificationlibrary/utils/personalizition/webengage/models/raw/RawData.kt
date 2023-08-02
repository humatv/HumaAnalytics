package ir.huma.notificationlibrary.utils.personalizition.webengage.models.raw

import ir.huma.notificationlibrary.utils.personalizition.webengage.models.PersonalizationModel

data class RawData(
    val value : HashMap<String,Any>?,
): PersonalizationModel
