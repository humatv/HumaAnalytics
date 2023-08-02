package ir.huma.notificationlibrary.utils.personalizition

import com.webengage.personalization.data.WECampaignContent
import com.webengage.personalization.data.WECampaignData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.footer.FooterData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.promotion.MiniPromotionData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.vote.VoteData

object FakeWECampaignData {
    private fun getCorrectMiniModel(MiniPromotionData: MiniPromotionData, type:String?= "miniPromotion"): WECampaignData {
        val customHashMap = hashMapOf<String , Any>()
        type?.let { customHashMap["type"] = type }
        MiniPromotionData.id?.let { customHashMap.put("id" , it) }
        MiniPromotionData.title?.let { customHashMap.put("title" , it) }
        MiniPromotionData.description?.let { customHashMap.put("description" , it) }
        MiniPromotionData.imageUrl?.let { customHashMap.put("imageUrl" , it) }
        MiniPromotionData.linkUrl?.let { customHashMap.put("linkUrl" , it) }
        MiniPromotionData.senderPackageName?.let { customHashMap.put("senderPackageName" , it) }
        MiniPromotionData.badgeImageUrl?.let { customHashMap.put("badgeImageUrl" , it) }
        MiniPromotionData.badgeTitle?.let { customHashMap.put("badgeTitle" , it) }
        MiniPromotionData.headerId?.let { customHashMap.put("headerId" , it) }
        MiniPromotionData.index.let { customHashMap.put("index" , it.toString()) }

        val inputContent = WECampaignContent(customData = customHashMap)
        return WECampaignData(null , "test" , inputContent ,)
    }
    private fun getCorrectFooter(FooterData: FooterData, type:String?= "footer"): WECampaignData {
        val customHashMap = hashMapOf<String , Any>()
        type?.let { customHashMap["type"] = type }
        FooterData.title?.let { customHashMap.put("title" , it) }
        FooterData.description?.let { customHashMap.put("description" , it) }
        FooterData.linkUrl?.let { customHashMap.put("linkUrl" , it) }
        FooterData.senderPackageName?.let { customHashMap.put("senderPackageName" , it) }

        val inputContent = WECampaignContent(customData = customHashMap)
        return WECampaignData(null , "test" , inputContent ,)
    }
    private fun getCorrectVote(voteData: VoteData, type:String?= "vote"): WECampaignData {
        val customHashMap = hashMapOf<String , Any>()
        type?.let { customHashMap["type"] = type }

       voteData.id?.let { customHashMap.put("id",it) }
        voteData.questionId?.let { customHashMap.put("questionId",it) }
        voteData.title?.let { customHashMap.put("title",it) }
        voteData.description?.let { customHashMap.put("description",it) }
        voteData.choiceList?.let { customHashMap.put("choiceList",it) }
        voteData.condition?.let { customHashMap.put("condition",it) }
        voteData.positiveButtonTitle?.let { customHashMap.put("positiveButtonTitle",it) }
        voteData.negativeButtonTitle?.let { customHashMap.put("negativeButtonTitle",it) }

        val inputContent = WECampaignContent(customData = customHashMap)
        return WECampaignData(null , "test" , inputContent ,)
    }
    fun getFullMiniPromotionModel(): WECampaignData{

        return getCorrectMiniModel(
            MiniPromotionData(
                id = "id",
                title = "title",
                description = "description",
                imageUrl = "imageUrl",
                linkUrl = "linkUrl",
                senderPackageName = "senderPackageName",
                headerId = "headerId",
                badgeImageUrl = "badgeImageUrl" ,
                badgeTitle = "badgeTitle" ,
                index = 10 ,
            )
        )
    }
    fun getFullVoteModel(): WECampaignData{

        val customHashMap = hashMapOf<String , Any>(
            Pair("id","id"),
            Pair("questionId","questionId"),
            Pair("title","title"),
            Pair("description","description"),
            Pair("condition","condition"),
            Pair("positiveButtonTitle","positiveButtonTitle"),
            Pair("negativeButtonTitle","negativeButtonTitle"),
            Pair("metaData","metaData"),
            Pair("choice1","choice1"),
            Pair("choice2","choice2"),
            Pair("choice3","choice3"),
            Pair("choice4","choice4"),
            Pair("choice5","choice5"),
            Pair("choice6","choice6"),
            Pair("type","vote"),
        )

        val inputContent = WECampaignContent(customData = customHashMap)
        return WECampaignData(null , "test" , inputContent ,)
    }
    fun getFullFooterModel(): WECampaignData{

        return getCorrectFooter(FooterData(
            title = "title",
            description = "description",
            linkUrl = "linkUrl",
            senderPackageName = "senderPackageName",
        ))
    }
    fun getFullMiniPromotionModelWithoutType(): WECampaignData{

        return getCorrectMiniModel(
            MiniPromotionData(
            id = "id",
            title = "title",
            description = "description",
            imageUrl = "imageUrl",
            linkUrl = "linkUrl",
            senderPackageName = "senderPackageName",
            headerId = "headerId",
            badgeImageUrl = "badgeImageUrl" ,
            badgeTitle = "badgeTitle" ,
            index = 10,
        ),null)
    }

    private fun trackClick(attributes: Map<String, Any>? = null) {
        println("clicked attributes:$attributes")
        assert(false)
    }
}