package ir.huma.notificationlibrary.utils.personalizition

import ir.huma.notificationlibrary.utils.personalizition.webengage.models.promotion.MiniPromotionData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.raw.RawData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.vote.VoteData
import kotlin.reflect.KClass

interface PersonalizationUtilInterface {

    fun getVoteData(parentId:String, onDataReceived:(data: VoteData?)->Unit)
    fun getPromotionData(parentId:String, onDataReceived:(data: MiniPromotionData?)->Unit)
    fun getRawData(parentId:String, onDataReceived:(data: RawData?)->Unit)
    fun getJsonData(parentId:String, modelClass:KClass<*>, onDataReceived:(data:Any?)->Unit)
    fun getJsonStringData(parentId:String, onDataReceived:(data:String?)->Unit)

}