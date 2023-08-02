package ir.huma.notificationlibrary.utils.personalizition

import ir.huma.notificationlibrary.utils.personalizition.webengage.mapper.PersonalizationMapperImpl
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.footer.FooterData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.promotion.MiniPromotionData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.vote.VoteData
import org.junit.Test


class PersonalizationMapperImplTest {


    @Test
    fun mapToPersonalizationForMiniPromotionWhenAllDataIsAvailable() {
        println("start")
        val inputData = FakeWECampaignData.getFullMiniPromotionModel()
        val result = PersonalizationMapperImpl().mapToPersonalization(inputData)
        println("start")
        if (result is MiniPromotionData) {
            if (result.id != "id")
                assert(false)
            if (result.title != "title")
                assert(false)
            if (result.description != "description")
                assert(false)
            if (result.imageUrl != "imageUrl")
                assert(false)
            if (result.linkUrl != "linkUrl")
                assert(false)
            if (result.senderPackageName != "senderPackageName")
                assert(false)
            if (result.headerId != "headerId") {
                println(result.headerId)
                assert(false)
            }
            if (result.badgeImageUrl != "badgeImageUrl"){
                println(result.badgeImageUrl)
                assert(false)
            }
            if (result.badgeTitle != "badgeTitle")
                assert(false)
            if (result.index != 10){
                println("index:"+result.index)
                assert(false)
            }

            assert(true)

        } else {
            assert(false)
        }
    }

    @Test
    fun mapToPersonalizationForMiniPromotionWhenNoTypeDefined() {
        println("start")
        val inputData = FakeWECampaignData.getFullMiniPromotionModelWithoutType()
        val result = PersonalizationMapperImpl().mapToPersonalization(inputData)
        if (result is MiniPromotionData) {
            assert(false)
        } else {
            assert(true)
        }
    }

    @Test
    fun mapToPersonalizationForFooterWhenAllDataIsAvailable() {
        println("start")
        val inputData = FakeWECampaignData.getFullFooterModel()
        val result = PersonalizationMapperImpl().mapToPersonalization(inputData)

        if (result is FooterData) {

            if (result.title != "title")
                assert(false)
            if (result.description != "description")
                assert(false)
            if (result.linkUrl != "linkUrl")
                assert(false)
            if (result.senderPackageName != "senderPackageName")
                assert(false)

            assert(true)

        } else {
            assert(false)
        }
    }

    @Test
    fun mapToPersonalizationForVoteWhenAllDataIsAvailable() {
        println("start")
        val inputData = FakeWECampaignData.getFullVoteModel()
        val result = PersonalizationMapperImpl().mapToPersonalization(inputData)

        if (result is VoteData) {

            if (result.id != "id") assert(false)
            if (result.questionId != "questionId") assert(false)
            if (result.title != "title") assert(false)
            if (result.description != "description") assert(false)
            if (result.metaData != "metaData") assert(false)
            if (result.condition != "condition") assert(false)
            if (result.positiveButtonTitle != "positiveButtonTitle") assert(false)
            if (result.negativeButtonTitle != "negativeButtonTitle") assert(false)
            if (result.choiceList.isNullOrEmpty()) assert(false)

            assert(true)
        } else {
            assert(false)
        }
    }

    @Test
    fun mapToPersonalizationForVoteChoiceListWhenAllDataIsAvailable() {
        println("start")
        val inputData = FakeWECampaignData.getFullVoteModel()
        val result = PersonalizationMapperImpl().mapToPersonalization(inputData)

        if (result is VoteData) {
            result.choiceList?.forEachIndexed { index, choice ->
                println(result.choiceList?.get(index))
                if (choice != "choice${index+VoteData.minChoice}") assert(false)
            }


            assert(true)
        } else {
            assert(false)
        }
    }

}