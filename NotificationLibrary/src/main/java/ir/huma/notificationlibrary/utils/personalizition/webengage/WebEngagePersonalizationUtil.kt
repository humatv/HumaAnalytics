package ir.huma.notificationlibrary.utils.personalizition.webengage

import com.google.gson.Gson
import com.webengage.personalization.WEPersonalization
import com.webengage.personalization.data.WECampaignData
import ir.huma.notificationlibrary.utils.personalizition.PersonalizationUtilInterface
import ir.huma.notificationlibrary.utils.personalizition.webengage.mapper.PersonalizationMapper
import ir.huma.notificationlibrary.utils.personalizition.webengage.mapper.PersonalizationMapperImpl
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.PersonalizationModel
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.json.JsonData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.promotion.MiniPromotionData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.promotionlist.MiniPromotionListData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.raw.RawData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.vote.VoteData
import kotlin.reflect.KClass

object WebEngagePersonalizationUtil : PersonalizationUtilInterface {

    private val personalizationMapper: PersonalizationMapper = PersonalizationMapperImpl()

    override fun getVoteData(
        parentId: String,
        onDataReceived: (data: VoteData?) -> Unit,
    ) {
        WEPersonalization.Companion.get()
            .registerWEPlaceholderCallback(
                parentId,
                object : PersonalizedPlaceHolder<VoteData>(onDataReceived) {
                    override fun onDataPrepared(data: PersonalizationModel) {
                        onDataReceived.invoke(data as? VoteData)
                    }
                })
    }

    override fun getPromotionData(
        parentId: String,
        onDataReceived: (data: MiniPromotionData?) -> Unit,
    ) {
        WEPersonalization.Companion.get()
            .registerWEPlaceholderCallback(
                parentId,
                object : PersonalizedPlaceHolder<MiniPromotionData>(onDataReceived) {
                    override fun onDataPrepared(data: PersonalizationModel) {
                        onDataReceived.invoke(data as? MiniPromotionData)
                    }
                })
    }

    override fun getPromotionListData(
        parentId: String,
        onDataReceived: (data: MiniPromotionListData?) -> Unit,
    ) {
        WEPersonalization.Companion.get()
            .registerWEPlaceholderCallback(
                parentId,
                object : PersonalizedPlaceHolder<MiniPromotionListData>(onDataReceived) {
                    override fun onDataPrepared(data: PersonalizationModel) {
                        onDataReceived.invoke(data as? MiniPromotionListData)
                    }
                })

    }

    override fun getRawData(
        parentId: String,
        onDataReceived: (data: RawData?) -> Unit,
    ) {
        WEPersonalization.Companion.get()
            .registerWEPlaceholderCallback(
                parentId,
                object : PersonalizedPlaceHolder<RawData>(onDataReceived) {
                    override fun onDataPrepared(data: PersonalizationModel) {
                        onDataReceived.invoke(data as? RawData)
                    }
                })
    }

    override fun getJsonData(
        parentId: String,
        modelClass: KClass<*>,
        onDataReceived: (data: Any?) -> Unit,
    ) {
        WEPersonalization.Companion.get()
            .registerWEPlaceholderCallback(parentId, object : CustomPlaceholderCallback {

                override fun onDataReceived(data: WECampaignData) {
                    val personalizationModel = personalizationMapper.mapToPersonalization(data)
                    if (personalizationModel is JsonData) {
                        val gson = Gson()
                        val convertedModel =
                            gson.fromJson(personalizationModel.data, modelClass::class.java)
                        onDataReceived.invoke(convertedModel)
                    } else {
                        onDataReceived.invoke(null)
                    }
                }

                override fun onPlaceholderException(
                    campaignId: String?,
                    targetViewId: String,
                    error: Exception,
                ) {
                    onDataReceived.invoke(null)

                }

            })
    }

    override fun getJsonStringData(
        parentId: String,
        onDataReceived: (data: String?) -> Unit,
    ) {
        WEPersonalization.Companion.get()
            .registerWEPlaceholderCallback(parentId, object : CustomPlaceholderCallback {

                override fun onDataReceived(data: WECampaignData) {
                    val personalizationModel = personalizationMapper.mapToPersonalization(data)
                    if (personalizationModel is JsonData) {
                        onDataReceived.invoke(personalizationModel.data)
                    } else {
                        onDataReceived.invoke(null)
                    }
                }

                override fun onPlaceholderException(
                    campaignId: String?,
                    targetViewId: String,
                    error: Exception,
                ) {
                    onDataReceived.invoke(null)

                }

            })
    }
}

