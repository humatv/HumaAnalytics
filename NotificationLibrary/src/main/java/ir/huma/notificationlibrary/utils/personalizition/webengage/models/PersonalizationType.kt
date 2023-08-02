package ir.huma.notificationlibrary.utils.personalizition.webengage.models

import androidx.annotation.Keep

@Keep
enum class PersonalizationType(private val value:String) {
    MiniPromotion("miniPromotion"),
    MiniPromotionList("miniPromotionList"),
    Footer("footer"),
    Vote("vote"),
    Json("json"),
    RawData("rowData");

    companion object {
        fun from(inputValue: String): PersonalizationType? = PersonalizationType.values().find { it.value == inputValue }

    }
}