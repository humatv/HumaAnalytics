package ir.huma.notificationlibrary.utils.personalizition

import ir.huma.notificationlibrary.utils.personalizition.webengage.WebEngagePersonalizationUtil
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.promotion.MiniPromotionData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.promotionlist.MiniPromotionListData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.raw.RawData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.vote.VoteData
import kotlin.reflect.KClass

object PersonalizationUtil : PersonalizationUtilInterface {
    private val  webEngagePersonalizationUtil :PersonalizationUtilInterface = WebEngagePersonalizationUtil


    override fun getVoteData(
        parentId: String,
        onDataReceived: (data: VoteData?) -> Unit,
    ) {
        webEngagePersonalizationUtil.getVoteData(parentId,onDataReceived)
    }

    override fun getPromotionData(
        parentId: String,
        onDataReceived: (data: MiniPromotionData?) -> Unit,
    ) {
        webEngagePersonalizationUtil.getPromotionData(parentId,onDataReceived)
    }

    override fun getPromotionListData(
        parentId: String,
        onDataReceived: (data: MiniPromotionListData?) -> Unit,
    ) {
        webEngagePersonalizationUtil.getPromotionListData(parentId,onDataReceived)
    }

    override fun getRawData(
        parentId: String,
        onDataReceived: (data: RawData?) -> Unit,
    ) {
        webEngagePersonalizationUtil.getRawData(parentId,onDataReceived)
    }

    override fun getJsonData(
        parentId: String,
        modelClass: KClass<*>,
        onDataReceived: (data: Any?) -> Unit
    ) {
        webEngagePersonalizationUtil.getJsonData(parentId,modelClass,onDataReceived)
    }

    override fun getJsonStringData(
        parentId: String,
        onDataReceived: (data: String?) -> Unit,
    ) {
        webEngagePersonalizationUtil.getJsonStringData(parentId,onDataReceived)

    }
    inline fun <reified T > getJsonDataFromWebEngage(
        parentId: String,
        noinline onDataReceived: (data: Any?) -> Unit,
    ) = WebEngagePersonalizationUtil.getJsonData(parentId, T::class,onDataReceived )

}