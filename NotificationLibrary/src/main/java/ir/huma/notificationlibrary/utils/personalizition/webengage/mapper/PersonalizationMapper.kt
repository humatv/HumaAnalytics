package ir.huma.notificationlibrary.utils.personalizition.webengage.mapper

import com.webengage.personalization.data.WECampaignData
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.PersonalizationModel
import java.util.HashMap

interface PersonalizationMapper {
    fun mapToPersonalization(data: WECampaignData): PersonalizationModel?
    fun getJsonConverter(safeData: HashMap<String, Any>): PersonalizationModel
    fun getVoteConverter(safeData: HashMap<String, Any>): PersonalizationModel
    fun getMiniPromotionConverter(safeData: HashMap<String, Any>): PersonalizationModel
    fun getFooterConverter(safeData: HashMap<String, Any>): PersonalizationModel
    fun getMiniPromotionListConverter(safeData: HashMap<String, Any>): PersonalizationModel?
}