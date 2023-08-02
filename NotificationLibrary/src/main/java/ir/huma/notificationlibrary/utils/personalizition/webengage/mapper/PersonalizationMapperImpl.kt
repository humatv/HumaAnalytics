package ir.huma.notificationlibrary.utils.personalizition.webengage.mapper

import com.webengage.personalization.data.WECampaignData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.PersonalizationModel
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.PersonalizationType
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.footer.FooterData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.json.JsonData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.promotion.MiniPromotionData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.raw.RawData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.vote.VoteData
import java.util.HashMap


class PersonalizationMapperImpl : PersonalizationMapper {
    override fun mapToPersonalization(data: WECampaignData): PersonalizationModel? {
        val type = data.content?.customData?.get("type").toString()
        data.content?.customData?.let { safeData ->
            when (PersonalizationType.from(type)) {
                PersonalizationType.Json -> {
                    return getJsonConverter(safeData)
                }
                PersonalizationType.Vote -> {
                    return getVoteConverter(safeData)
                }
                PersonalizationType.MiniPromotion -> {
                    return getMiniPromotionConverter(safeData)
                }
                PersonalizationType.Footer -> {
                    return getFooterConverter(safeData)
                }
                else -> {
                    return RawData(data.content?.customData)
                }
            }
        }
        return null
    }

    override fun getJsonConverter(safeData: HashMap<String, Any>): PersonalizationModel {
        val jsonData = safeData["jsonData"] as? String
        return JsonData(
            data = jsonData
        )
    }

    override fun getVoteConverter(safeData: HashMap<String, Any>): PersonalizationModel {
        val choiceList = ArrayList<String>()
        val id = safeData["id"] as? String
        val questionId = safeData["questionId"] as? String
        val title = safeData["title"] as? String
        val description = safeData["description"] as? String
        val condition = safeData["condition"] as? String
        val positiveButtonTitle = safeData["positiveButtonTitle"] as? String
        val negativeButtonTitle = safeData["negativeButtonTitle"] as? String
        val metaData = safeData["metaData"] as? String
        for (i in VoteData.minChoice..VoteData.maxChoice){
            val choice = safeData["choice$i"] as? String
            choice?.let {
                choiceList.add(choice)
            }
        }
        return VoteData(
            id=id ,
            questionId=questionId ,
            title=title ,
            description=description ,
            condition=condition ,
            positiveButtonTitle=positiveButtonTitle ,
            negativeButtonTitle=negativeButtonTitle ,
            metaData=metaData ,
            choiceList= choiceList,
        )

    }

    override fun getMiniPromotionConverter(safeData: HashMap<String, Any>): PersonalizationModel {

        val id = safeData["id"] as? String
        val title = safeData["title"] as? String
        val description = safeData["description"] as? String
        val imageUrl = safeData["imageUrl"] as? String
        val linkUrl = safeData["linkUrl"] as? String
        val senderPackageName = safeData["senderPackageName"] as? String
        val headerId = safeData["headerId"] as? String
        val badgeImageUrl = safeData["badgeImageUrl"] as? String
        val badgeTitle = safeData["badgeTitle"] as? String
        val index = safeData["index"] as? String
        return MiniPromotionData(
            id = id ,
            title = title ,
            description = description ,
            imageUrl = imageUrl ,
            linkUrl = linkUrl ,
            senderPackageName = senderPackageName ,
            headerId = headerId ,
            badgeImageUrl = badgeImageUrl ,
            badgeTitle=badgeTitle,
            index = index?.toIntOrNull()?:0 ,
        )
    }

    override fun getFooterConverter(safeData: HashMap<String, Any>): PersonalizationModel{
        val title = safeData["title"] as? String
        val description = safeData["description"] as? String
        val linkUrl = safeData["linkUrl"] as? String
        val senderPackageName = safeData["senderPackageName"] as? String
        return FooterData(
            title = title ,
            description = description ,
            linkUrl = linkUrl ,
            senderPackageName = senderPackageName ,
        )

    }
}