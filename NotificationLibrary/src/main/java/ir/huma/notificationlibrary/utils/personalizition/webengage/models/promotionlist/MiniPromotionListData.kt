package ir.huma.notificationlibrary.utils.personalizition.webengage.models.promotionlist

import androidx.annotation.Keep
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.PersonalizationModel
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.promotion.MiniPromotionData

@Keep
data class MiniPromotionListData(
    val id:String?,
    val title: String?,
    val index: Int = 1,
    val promotionList:List<MiniPromotionData>

): PersonalizationModel


