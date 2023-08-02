package ir.huma.notificationlibrary.utils.personalizition.webengage.models.promotion

import androidx.annotation.Keep
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.PersonalizationModel

@Keep
data class MiniPromotionData(
    val id: String? ,
    val title: String? ,
    val description: String? ,
    val imageUrl: String? ,
    val linkUrl: String? ,
    val senderPackageName: String? ,
    val headerId: String? ,
    val badgeImageUrl: String? ,
    val badgeTitle: String? ,
    val index: Int = 0
): PersonalizationModel

